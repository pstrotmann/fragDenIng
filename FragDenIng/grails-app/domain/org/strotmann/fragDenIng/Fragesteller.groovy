package org.strotmann.fragDenIng

class Fragesteller extends Teilnehmer {

	static hasMany = [fragen: Frage]

    static constraints = {
    }
	
	String toString() {"${this.nickname}"}
	
}
