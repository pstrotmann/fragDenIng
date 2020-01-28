package org.strotmann.fragDenIng

class Frage {

	String titel
	String text
	String antwort
	Date zeitGestellt
	Date zeitBeantwortet
	BigDecimal preisGeboten
	BigDecimal preisAkzeptiert

	static belongsTo = [fragesteller: Fragesteller]
	
	static hasMany = [angebote: Angebot]

    static constraints = {
		preisAkzeptiert nullable: true
		antwort nullable: true
		zeitBeantwortet nullable: true
    }
	
	Experte getExperte(){
		Experte e = null
		angebote.each {Angebot a ->
			if (a.akzeptiert)
				e = a.experte
		} 
		e
	}
	
	String toString() {"${this.titel} ${this.text} vom: ${this.zeitGestellt}"}
}
