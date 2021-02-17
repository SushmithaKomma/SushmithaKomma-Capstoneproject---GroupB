package hmtapp

class BootStrap {

    def mailService

    def init = { servletContext ->

        if (!User.findAll()) {

            // define admin and user roles
            def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
            def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

            // create admin accounts
            def admins = [[name: "admin", init: "admin", email: "admin@gmail.com"]]
            (admins).each {
                def admin = new User(username: it.name, password: it.init, email: it.email,
                        controller: true)
                admin.save(flush: true)
                UserRole.create admin, adminRole, true
            }

            def pratsSP = new User(username: "sush", password: "sush", email: "sushmitha.komma@gmail.com", controller: false)
            pratsSP.save(flush: true)
            UserRole.create pratsSP, userRole, true
            UserRole.withSession {
                it.flush()
                it.clear()
            }
        }
    }

    def destroy = {

    }

}
