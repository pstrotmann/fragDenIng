package org.strotmann.fragDenIng


import org.strotmann.partner.adapter.*
import static org.springframework.http.HttpStatus.*
import org.strotmann.fragDenIng.Fragesteller
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FragestellerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Fragesteller.list(params), model:[fragestellerInstanceCount: Fragesteller.count()]
    }

    def show(Fragesteller fragestellerInstance) {
        respond fragestellerInstance
    }

    def create() {
		flash.createMode = true
		session.partners = org.strotmann.partner.adapter.Partner.partners
		respond new Fragesteller(params)
    }

    @Transactional
    def save(Fragesteller fragestellerInstance) {
		if (fragestellerInstance == null) {
            notFound()
            return
        }
		
		Long partnerId
		if (params.partner == null || params.partner.id == 'null')
			partnerId = 0
		else
			partnerId = params.partner.id.toLong()

		if (fragestellerInstance.hasErrors()) {
            respond fragestellerInstance.errors, view:'create'
            return
        }

        fragestellerInstance.save flush:true
		Helper h = new Helper ('FragDenIng','Fragesteller',fragestellerInstance.id)
		h.saveRole(partnerId, 0)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'fragesteller.label', default: 'Fragesteller'), fragestellerInstance.id])
                redirect fragestellerInstance
            }
            '*' { respond fragestellerInstance, [status: CREATED] }
        }
    }

    def edit(Fragesteller fragestellerInstance) {
        respond fragestellerInstance
    }

    @Transactional
    def update(Fragesteller fragestellerInstance) {
		session.partners = org.strotmann.partner.adapter.Partner.partners
        if (fragestellerInstance == null) {
            notFound()
            return
        }
		
		Helper h = new Helper ('FragDenIng','Fragesteller',fragestellerInstance.id)
		long oldPartnerId = h.partnerId
		long partnerId
		
		if (params.partner.id == 'null')
			partnerId = 0
		else
			partnerId = params.partner.id.toLong()

        if (fragestellerInstance.hasErrors()) {
            respond fragestellerInstance.errors, view:'edit'
            return
        }

		fragestellerInstance.save flush:true
		
		if (partnerId > 0 && oldPartnerId != partnerId) 
			h.saveRole(partnerId, oldPartnerId)
		
		request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Fragesteller.label', default: 'Fragesteller'), fragestellerInstance.id])
                redirect fragestellerInstance
            }
            '*'{ respond fragestellerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Fragesteller fragestellerInstance) {

        if (fragestellerInstance == null) {
            notFound()
            return
        }

        fragestellerInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Fragesteller.label', default: 'Fragesteller'), fragestellerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
	
	def toPartner(Fragesteller fragestellerInstance) {
		Helper h = new Helper ('FragDenIng','Fragesteller',fragestellerInstance.id)
		//Anmeldung bei Partner setzen
		fragestellerInstance.loginPartner()
		String s =request.getRequestURL()
		String[] splits = s.split("/")
		String uri = "http://"+splits[2]+"/"+splits[3]+"/"+"Fragesteller"
		h.saveRueckUri(uri)
		def partnerUri = h.partnerUri
		def partnerId = h.partnerId
		def partnerArt = h.partnerArt
		redirect(uri: "${partnerUri}/${partnerArt}/show/${partnerId}")
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'fragesteller.label', default: 'Fragesteller'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}