environments {
    development {
        grails {
            mail {
                host = "smtp.gmail.com"
                port = 465
                username = ""
                password = ""
                props = ["mail.smtp.auth":"true",
                         "mail.smtp.debug":"true",
                         "mail.smtp.starttls.enable":"true",
                         "mail.smtp.starttls.required":"true",
                         "mail.smtp.socketFactory.port":"465",
                         "mail.smtp.socketFactory.fallback":"false"]
            }
        }
    }
    test {
        uploadFolder = "C:/temp/upload/"
    }
    production {
        uploadFolder = "/home/jon/temp/upload/"
    }
}
