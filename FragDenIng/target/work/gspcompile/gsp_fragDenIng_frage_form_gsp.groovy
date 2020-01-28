import org.strotmann.fragDenIng.Frage
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fragDenIng_frage_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/frage/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: frageInstance, field: 'fragesteller', 'error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("frage.fragesteller.label"),'default':("Fragesteller")],-1)
printHtmlPart(2)
invokeTag('select','g',15,['id':("fragesteller"),'name':("fragesteller.id"),'from':(session.user?:org.strotmann.fragDenIng.Fragesteller.list()),'optionKey':("id"),'required':(""),'value':(frageInstance?.fragesteller?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: frageInstance, field: 'preisGeboten', 'error'))
printHtmlPart(4)
invokeTag('message','g',19,['code':("frage.preisGeboten.label"),'default':("Preis Geboten")],-1)
printHtmlPart(2)
invokeTag('field','g',23,['name':("preisGeboten"),'required':(""),'value':(fieldValue(bean: frageInstance, field: 'preisGeboten'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: frageInstance, field: 'titel', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("frage.titel.label"),'default':("Titel")],-1)
printHtmlPart(2)
invokeTag('textField','g',30,['name':("titel"),'required':(""),'value':(frageInstance?.titel)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: frageInstance, field: 'text', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("frage.text.label"),'default':("Text")],-1)
printHtmlPart(2)
invokeTag('textArea','g',37,['name':("text"),'required':(""),'value':(frageInstance?.text),'rows':("4"),'cols':("80")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: frageInstance, field: 'zeitGestellt', 'error'))
printHtmlPart(7)
invokeTag('message','g',41,['code':("frage.zeitGestellt.label"),'default':("Zeit Gestellt")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',44,['name':("zeitGestellt"),'precision':("day"),'value':(frageInstance?.zeitGestellt)],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1580034687000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
