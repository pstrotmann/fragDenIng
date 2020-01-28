package org.strotmann.fragDenIng

import org.strotmann.partner.adapter.Partner

class Teilnehmer {
	
	String nickname
	String passwort
	String sprache
	
	static mapping = {
		tablePerHierarchy false
	}

    static constraints = {
		nickname(unique:true)
		passwort()
		sprache(inList:["de"])
    }
	
	Boolean loginPartner() {
		//vorläufig hart codiert, da diese Anwendung noch kein Anmeldebild hat
		Partner.appUserLogin('userDe', 'wauwau')
	}
}
