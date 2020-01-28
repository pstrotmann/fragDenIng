package org.strotmann.fragDenIng

class Angebot {

	Frage frage
	BigDecimal preis // zu dem der Experte die Beantwortung der Frage anbietet
	Date termin // zu dem der Experte die Beantwortung der Frage zusagt
	Boolean akzeptiert
	
	static belongsTo = [experte: Experte]
	
	static constraints = {		
		frage()
		preis()
		termin(nullable:true)
		akzeptiert()
    }
	
	String toString() {"${this.frage?this.frage.titel:''} ${this.experte?this.experte.nickname:''}"}
}
