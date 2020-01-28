package org.strotmann.fragDenIng

class VorabfrageController {

    def index() {
		session.vorabfrage = params.vorabfrage
		redirect(uri: "/teilnehmer/login")
		//		redirect(uri: "/frage/create", params:[text: params.vorabfrage])
	}
}
