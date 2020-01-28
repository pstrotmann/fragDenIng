package org.strotmann.fragDenIng

import org.strotmann.fragDenIng.Teilnehmer;

class TeilnehmerController {

    def scaffold = true
	
	def login() {
		if (request.get) {
			return // render the login view
		}
		def u = Teilnehmer.findByNickname(params.name)
		if (u) {
			if (u.passwort == params.passwort) {
				session.user = u
				redirect(uri: "/frage/create", params: [lang: u.sprache, text:session.vorabfrage?:' '])
			}
			else {
				flash.message = "Passwort falsch"
				render(view: "login")
			}
		}
		else {
			flash.message = "Teilnehmer unbekannt, Sie können sich registrieren"
			flash.name = params.name
			render(view: "login")
		}
	}
}
