package org.strotmann.fragDenIng

class User {

	String name
	String passwort

    static constraints = {
		name(unique:true)
		passwort()
    }
	
	String toString() {
		name
	}
}
