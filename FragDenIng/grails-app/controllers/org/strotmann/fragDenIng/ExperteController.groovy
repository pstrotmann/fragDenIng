package org.strotmann.fragDenIng


import org.strotmann.partner.adapter.*
import static org.springframework.http.HttpStatus.*
import org.strotmann.fragDenIng.Experte
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ExperteController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Experte.list(params), model:[experteInstanceCount: Experte.count()]
    }

    def show(Experte experteInstance) {
        respond experteInstance
    }

    def create() {
		session.partners = org.strotmann.partner.adapter.Partner.partners
		respond new Experte(params)
    }

    @Transactional
    def save(Experte experteInstance) {
		if (experteInstance == null) {
            notFound()
            return
        }
		
		Long partnerId
		if (params.partner.id == 'null')
			partnerId = 0
		else
			partnerId = params.partner.id.toLong()

        if (experteInstance.hasErrors()) {
            respond experteInstance.errors, view:'create'
            return
        }

		experteInstance.save flush:true
		Helper h = new Helper ('FragDenIng','Experte',experteInstance.id) 
		h.saveRole(partnerId, 0)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'experte.label', default: 'Experte'), experteInstance.id])
                redirect experteInstance
            }
            '*' { respond experteInstance, [status: CREATED] }
        }
    }

    def edit(Experte experteInstance) {
        respond experteInstance
    }

    @Transactional
    def update(Experte experteInstance) {
        if (experteInstance == null) {
            notFound()
            return
        }
		session.partners = org.strotmann.partner.adapter.Partner.partners
		Helper h = new Helper ('FragDenIng','Experte',experteInstance.id)
		long oldPartnerId = h.partnerId
		long partnerId
		
		if (params.partner.id == 'null')
			partnerId = 0
		else
			partnerId = params.partner.id.toLong()

        if (experteInstance.hasErrors()) {
            respond experteInstance.errors, view:'edit'
            return
        }

        experteInstance.save flush:true
		
		if (partnerId > 0 && oldPartnerId != partnerId) 
			h.saveRole(partnerId, oldPartnerId)
		
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Experte.label', default: 'Experte'), experteInstance.id])
                redirect experteInstance
            }
            '*'{ respond experteInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Experte experteInstance) {

        if (experteInstance == null) {
            notFound()
            return
        }

        experteInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Experte.label', default: 'Experte'), experteInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
	
	def toPartner(Experte experteInstance) {
		Helper h = new Helper ('FragDenIng','Experte',experteInstance.id)
		//Anmeldung bei Partner setzen
		experteInstance.loginPartner()
		String s =request.getRequestURL()
		String[] splits = s.split("/")
		String uri = "http://"+splits[2]+"/"+splits[3]+"/"+"Experte"
		h.saveRueckUri(uri)
		def partnerUri = h.partnerUri
		def partnerId = h.partnerId
		def partnerArt = h.partnerArt
		redirect(uri: "${partnerUri}/${partnerArt}/show/${partnerId}")
	}

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'experte.label', default: 'Experte'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}