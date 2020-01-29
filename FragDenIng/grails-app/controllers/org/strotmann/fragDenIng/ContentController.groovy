package org.strotmann.fragDenIng

class ContentController {

    def index() { 
		redirect(uri: "/")
	}
	
	def widerrufsbelehrung() {
		render(view: "widerrufsbelehrung")
	}
	
	def impressum() {
		render(view: "impressum")
	}
	
	def agb() {
		render(view: "agb")
    }
	
	def datenschutz() {
		render(view: "datenschutz")
	}
	
	def soFunktioniert() {
		render(view: "soFunktioniert")
	}
}
