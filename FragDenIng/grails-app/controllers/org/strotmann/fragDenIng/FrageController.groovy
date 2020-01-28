package org.strotmann.fragDenIng



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FrageController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		params.max = Math.min(max ?: 10, 100)
        respond Frage.list(params), model:[frageInstanceCount: Frage.count()]
    }

    def show(Frage frageInstance) {
        respond frageInstance
    }

    def create() {
		respond new Frage(params)
    }

    @Transactional
    def save(Frage frageInstance) {
        if (frageInstance == null) {
            notFound()
            return
        }

        if (frageInstance.hasErrors()) {
            respond frageInstance.errors, view:'create'
            return
        }

        frageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'frage.label', default: 'Frage'), frageInstance.id])
                redirect frageInstance
            }
            '*' { respond frageInstance, [status: CREATED] }
        }
    }

    def edit(Frage frageInstance) {
        respond frageInstance
    }

    @Transactional
    def update(Frage frageInstance) {
        if (frageInstance == null) {
            notFound()
            return
        }

        if (frageInstance.hasErrors()) {
            respond frageInstance.errors, view:'edit'
            return
        }

        frageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Frage.label', default: 'Frage'), frageInstance.id])
                redirect frageInstance
            }
            '*'{ respond frageInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Frage frageInstance) {

        if (frageInstance == null) {
            notFound()
            return
        }

        frageInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Frage.label', default: 'Frage'), frageInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'frage.label', default: 'Frage'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
