package fragdening

class SecurityFilters {

    def filters = {
        loginCheckFrage(controller:'frage', action:'*') {
            before = {
				if (!session.user && actionName != "login") {
					redirect(controller: "teilnehmer", action: "login")
					return false
				}
            }
        }
		
		loginCheckAngebot(controller:'angebot', action:'*') {
			before = {
				if (!session.user && actionName != "login") {
					redirect(controller: "teilnehmer", action: "login")
					return false
				}
			}
		}
		loginCheck(controller: 'user', action: 'login', invert: true) {
			before = {
				if (!session.masterUser && actionName != "login") {
					redirect(controller: "user", action: "login")
				}
			}
		}
    }
}
