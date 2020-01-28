package org.strotmann.fragDenIng

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AngebotController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Angebot.list(params), model:[angebotInstanceCount: Angebot.count()]
    }

    def show(Angebot angebotInstance) {
        respond angebotInstance
    }

    def create() {
		respond new Angebot(params)
    }

    @Transactional
    def save(Angebot angebotInstance) {
		if (angebotInstance == null) {
            notFound()
            return
        }

        if (angebotInstance.hasErrors()) {
            respond angebotInstance.errors, view:'create'
            return
        }

        Frage frageInstance = Frage.get(params.frage.id)
		frageInstance.antwort = params.antwort
		frageInstance.save flush:true
		angebotInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'angebot.label', default: 'Angebot'), angebotInstance.id])
                redirect angebotInstance
            }
            '*' { respond angebotInstance, [status: CREATED] }
        }
    }

    def edit(Angebot angebotInstance) {
        respond angebotInstance
    }

    @Transactional
    def update(Angebot angebotInstance) {
        if (angebotInstance == null) {
            notFound()
            return
        }

        if (angebotInstance.hasErrors()) {
            respond angebotInstance.errors, view:'edit'
            return
        }

        angebotInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Angebot.label', default: 'Angebot'), angebotInstance.id])
                redirect angebotInstance
            }
            '*'{ respond angebotInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Angebot angebotInstance) {

        if (angebotInstance == null) {
            notFound()
            return
        }

        angebotInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Angebot.label', default: 'Angebot'), angebotInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'angebot.label', default: 'Angebot'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
