package org.strotmann.fragDenIng

class UserController {

    def scaffold = true
	
	def login() {
		if (request.get) {
			return // render the login view
		}
		def u = new User(name:'master', passwort:'khane')
		if (u) {
			if (u.passwort == params.passwort) {
				session.masterUser = u
				redirect(uri: "/")
			}
			else {
				flash.message = "Passwort falsch"
				render(view: "login")
			}
		}
		else {
			flash.message = "User unbekannt"
			flash.name = params.name
			render(view: "login")
		}
	}
	
	def logout() {
		session.user = null
		render(view: "login")
	}
}
