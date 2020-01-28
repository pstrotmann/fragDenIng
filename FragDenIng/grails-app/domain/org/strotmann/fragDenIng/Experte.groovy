package org.strotmann.fragDenIng

class Experte extends Teilnehmer {
	
	String qualitätsnachweis
	String registrierungsstatus
	String fachgebiet
		
	static hasMany = [angebote: Angebot]
	
	String toString() {"${this.nickname}"}
	
	static constraints = {
		qualitätsnachweis (inList:qualitaetsnachweise,nullable:true)
		registrierungsstatus (inList:registrierungsstati,nullable:true)
		fachgebiet (inList:fachgebiete ,nullable:true)
	}
	
	static List getQualitaetsnachweise () {	
		grails.util.Holders.config.qualitaetsnachweise		
	}
	
	static List getRegistrierungsstati () {
		grails.util.Holders.config.registrierungsstati
	}
	
	static List getFachgebiete () {
		grails.util.Holders.config.fachgebiete
	}
}
