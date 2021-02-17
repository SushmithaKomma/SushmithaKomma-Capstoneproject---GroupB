

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'hmtApp.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'hmtApp.UserRole'
grails.plugin.springsecurity.authority.className = 'hmtApp.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['ROLE_USER', 'ROLE_ADMIN']],
	[pattern: '/annotate.gsp',      access: ['ROLE_USER', 'ROLE_ADMIN']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	//[pattern: '/**/favicon1.jpg', access: ['permitAll']],
    [pattern: '/controllerList/**', access: ['ROLE_ADMIN']],
    [pattern: '/user/**',             access: ['ROLE_ADMIN']],
    [pattern: '/role/**',             access: ['ROLE_ADMIN']],
    [pattern: '/registrationCode/**', access: ['ROLE_ADMIN']],
    [pattern: '/securityInfo/**',     access: ['ROLE_ADMIN']],
    [pattern: '/logout/**',           access: ['permitAll']],
    [pattern: '/dbconsole/**',           access: ['permitAll']],


]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	//[pattern: '/**/favicon1.jpg', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.logout.postOnly = false

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'hmtApp.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'hmtApp.UserRole'
grails.plugin.springsecurity.authority.className = 'hmtApp.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['ROLE_USER', 'ROLE_ADMIN']],
	[pattern: '/annotate.gsp',      access: ['ROLE_USER', 'ROLE_ADMIN']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	//[pattern: '/**/favicon1.jpg', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	//[pattern: '/**/favicon1.jpg', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.logout.postOnly = false

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'hmtapp.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'hmtapp.UserRole'
grails.plugin.springsecurity.authority.className = 'hmtapp.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['ROLE_USER', 'ROLE_ADMIN']],
	[pattern: '/annotate.gsp',      access: ['ROLE_USER', 'ROLE_ADMIN']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
//	[pattern: '/**/favicon1.jpg', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	//[pattern: '/**/favicon1.jpg', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

//added to avoid login screens for dbconsole
grails.plugin.springsecurity.rejectIfNoRule = false
grails.plugin.springsecurity.fii.rejectPublicInvocations = false

// email validation not needed for password reset
grails.plugin.springsecurity.ui.forgotPassword.requireForgotPassEmailValidation = false


environments {
	production {
		grails.dbconsole.enabled = true
		grails.dbconsole.urlRoot = '/dbconsole'
	}
}
