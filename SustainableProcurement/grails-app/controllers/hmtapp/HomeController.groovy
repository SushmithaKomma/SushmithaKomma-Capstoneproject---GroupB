package hmtapp

import grails.plugin.springsecurity.annotation.Secured
import org.apache.commons.validator.routines.EmailValidator

import java.text.SimpleDateFormat

@Secured(['ROLE_USER', 'ROLE_ADMIN'])
class HomeController {

    def springSecurityService

    // admin(): Administrator home page
    def admin() {

        def uName = springSecurityService.principal.username
        def user = User.findByUsername(uName)
        def adminRole = Role.findByAuthority('ROLE_ADMIN')
        def userRole = Role.findByAuthority('ROLE_USER')
        def isAdmin = UserRole.countByUserAndRole(user, adminRole)
        def activeUserRolePairs = []
        def activeAdminRolePairs = []
        UserRole.findAllByRole(userRole).collect{
            if(it.user.enabled)
            {
                activeUserRolePairs += it
            }
        }
        UserRole.findAllByRole(adminRole).collect{
            if(it.user.enabled)
            {
                activeAdminRolePairs += it
            }
        }
        if (!isAdmin) {
            redirect(action: "index")
        }
        Date today = new Date().clearTime()

        [
                loginName: uName,
                numAdmins: activeAdminRolePairs.size(),
                numUsers: activeUserRolePairs.size(),
        ]
    }

    // index(): Main home page
    def index() {

        if(params.list('referral'))
            redirect()
        def uName = springSecurityService.principal.username
        def user = User.findByUsername(uName)
        def adminRole = Role.findByAuthority('ROLE_ADMIN')
        def userRole = Role.findByAuthority('ROLE_USER')
        def isAdmin = UserRole.countByUserAndRole(user, adminRole)
        if (isAdmin) {
            redirect(action: "admin")
        }

        Date today = new Date().clearTime()
        if (!user.login.find { it == today }) {
            user.login.add(today)
            user.save(flush: true)
        }
        [
            loginName: uName,
        ]
    }

    def accept() {
        def uName = springSecurityService.principal.username
        def user = User.findByUsername(uName)
        user.save(flush: true)
        redirect(action: "index")
    }

    def refuse() {
        def uName = springSecurityService.principal.username
        def user = User.findByUsername(uName)
        user.save(flush: true)
        redirect(controller: "Logout")
    }

    // dismiss(): Dismiss an alert
    // Source: index.gsp
    // Destination: index()
    // Parameter: category
    def dismiss() {

        // Set the appropriate dismissed flag to true
        session["dismissed" + params.category] = true
        redirect(action: "index")

    }

    def showToggle() {
        def uName = springSecurityService.principal.username
        def thisUser = User.findByUsername(uName)
        def cat = params.category
        def showVal = thisUser.show.get(cat)
        thisUser.show.put(cat, !showVal)
        if (!thisUser.save(flush: true)) {
            thisUser.errors.allErrors.each {
                println it
            }
        }
        redirect(action: "index")
    }

    // editAccount(): Prompt for info on new user account (either household user or admin)
    // Source: Home/admin.gsp
    // Destinations: submitAccount(), Home/admin()
    // Parameters: none
    def editAccount() {

        def user = User.findByUsername(params.oldUsername)
        def adminRole = Role.findByAuthority('ROLE_ADMIN')
        [
            user : user,
            oldUsername : params.oldUsername,
            oldEmail : (user ? user.email : null),
            isAdmin : UserRole.countByUserAndRole(user, adminRole),
            nameInUse: session["nameInUse"],
            invalidEmail: session["invalidEmail"],
        ]
    }

    // consent(): Give user option to give/deny consent for study
    def consent() {

    }

    // submitAccount(): Save new user account information
    // Source: Home/editAccount.gsp
    // Destination: Home/admin(), Home/viewAllAccounts()
    // Parameters: userName, password, email, role
    def submitAccount() {

        def newAccount = !params.oldUsername
        def thisUser = (newAccount ? new User() : User.findByUsername(params.oldUsername))
        def oldName = thisUser.username
        def newName = params.username
        EmailValidator ev = new EmailValidator(false)
        session["nameInUse"] = ( (!oldName || oldName != newName) && User.countByUsername(newName) ? newName : null)
        session["invalidEmail"] = (!ev.isValid(params.email) ? params.email : null)

        if (session["nameInUse"] || session["invalidEmail"]) {

            redirect(action: "editAccount", params: [oldUsername: oldName])

        } else {

            thisUser.username = newName
            if (!oldName) {
                thisUser.password = params.password
            }
            thisUser.email = params.email
            if (!thisUser.save(flush: true)) {
                thisUser.errors.allErrors.each {
                    println it
                }
            }

            if (newAccount) {
                // Set role according to admin parameter
                String roleName = (params.admin ? 'ROLE_ADMIN' : 'ROLE_USER')
                def role = Role.findByAuthority(roleName)
                UserRole.create thisUser, role, true
            }

            redirect(action: (newAccount ? "admin" : "viewAllAccounts"))

        }

    }

    def cancelAccountChange() {
        session["nameInUse"] = null
        session["invalidEmail"] = null
        redirect(action: (params.newAccount == "true" ? "index" : "viewAllAccounts"))
    }

    // viewAccount(): Admin view of singe household account
    // Source: viewAllAccounts.gsp
    // Destinations: Food/index(), Electricity/index(), Water/index()
    // Parameters: none
    def viewAccount() {

        def loginName = springSecurityService.principal.username
        def user = User.findByUsername(params.username)
        def adminRole = Role.findByAuthority('ROLE_ADMIN')
        def allAccountDetails = params.allAccountDetails
        if (!user) {
            redirect(action: "viewAllAccounts")
        }
        [
                loginName: loginName,
                username: (user ? user.username : ''),
                isAdmin: UserRole.countByUserAndRole(user, adminRole),
                allAccountDetails:allAccountDetails
        ]

    }

    // viewAllAccounts(): Admin view of all household accounts
    // Source: index.gsp
    // Destinations: Food/index(), Electricity/index(), Water/index()
    // Parameters: none
    def viewAllAccounts() {

        def loginName = springSecurityService.principal.username
        def userRole = Role.findByAuthority('ROLE_USER')
        def adminRole = Role.findByAuthority('ROLE_ADMIN')
        def adminRolePairs = UserRole.findAllByRole(adminRole)
        def allAccountDetails = params.allAccountDetails
        def finalUserRolePairs = []
        def activeAdminUserRolePairs = []
        UserRole.findAllByRole(userRole).collect{
            if(it.user.enabled)
            {
                finalUserRolePairs += it
            }
        }
        UserRole.findAllByRole(adminRole).collect{
            if(it.user.enabled)
            {
                activeAdminUserRolePairs += it
            }
        }
        [
            loginName: loginName,
            allUserNames: finalUserRolePairs.collect { it.user.username }.sort(),
            allAdminNames: activeAdminUserRolePairs.collect { it.user.username }.sort(),
            allAccountDetails:allAccountDetails,
            userCounts: User.findAllByEnabled(true).collect {
                [ user: it.username,
                  login: (it.login ? 0 : it.login.size()),
                  loginTime: (it.login ? it.login.get(it.login.size() - 1) : 0)
                ]
            }
        ]

    }

    def redirect() {
        if(params.list('referral') != null) {
            def referrals = params.list('referral')
            def uName = springSecurityService.principal.username
            def userFromDB = User.findByUsername(uName)
            userFromDB.referralCode = referrals
            userFromDB.save(flush: true)
        }
        //redirect(controller: "home", action: "confirmation", params: [text: "Utility API Authorization Form"])
    }


    def deleteAccount()
    {
        def userToDelete = User.findByUsername(params.oldUsername)
        if(userToDelete!=null)
        {
            userToDelete.setEnabled(false)
            userToDelete.save(flush: true)
        }
        redirect(action : "viewAllAccounts")
    }

    def viewUserLogins()
    {
        def loginName = springSecurityService.principal.username
        def uName = (params.userName ? params.userName : loginName)
        def user = User.findByUsernameAndEnabled(uName,true)
        def allAccountDetails = params.allAccountDetails
        def userLoginsDataFromDB = user.getLogin().sort().reverse()
        [
                loginName: loginName,
                uName: uName,
                userLoginsDataFromDB: userLoginsDataFromDB,
                allAccountDetails: allAccountDetails
        ]
    }

}
