import org.strotmann.fragDenIng.Angebot
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fragDenIng_angebot_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/angebot/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: angebotInstance, field: 'frage', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("angebot.frage.label"),'default':("Frage")],-1)
printHtmlPart(2)
invokeTag('select','g',8,['id':("frage"),'name':("frage.id"),'from':(org.strotmann.fragDenIng.Frage.list()),'optionKey':("id"),'required':(""),'value':(angebotInstance?.frage?.id),'class':("many-to-one")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: angebotInstance, field: 'frage.antwort', 'error'))
printHtmlPart(1)
invokeTag('message','g',14,['code':("angebot.frage.label"),'default':("Antwort")],-1)
printHtmlPart(4)
invokeTag('textArea','g',16,['name':("antwort"),'rows':("5"),'cols':("40")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: angebotInstance, field: 'preis', 'error'))
printHtmlPart(5)
invokeTag('message','g',22,['code':("angebot.preis.label"),'default':("Preis")],-1)
printHtmlPart(2)
invokeTag('field','g',25,['name':("preis"),'value':(fieldValue(bean: angebotInstance, field: 'preis')),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: angebotInstance, field: 'termin', 'error'))
printHtmlPart(6)
invokeTag('message','g',31,['code':("angebot.termin.label"),'default':("Termin")],-1)
printHtmlPart(7)
invokeTag('datePicker','g',34,['name':("termin"),'precision':("day"),'value':(angebotInstance?.termin),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: angebotInstance, field: 'akzeptiert', 'error'))
printHtmlPart(8)
invokeTag('message','g',40,['code':("angebot.akzeptiert.label"),'default':("Akzeptiert")],-1)
printHtmlPart(7)
invokeTag('checkBox','g',43,['name':("akzeptiert"),'value':(angebotInstance?.akzeptiert)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: angebotInstance, field: 'experte', 'error'))
printHtmlPart(9)
invokeTag('message','g',49,['code':("angebot.experte.label"),'default':("Experte")],-1)
printHtmlPart(2)
invokeTag('select','g',52,['id':("experte"),'name':("experte.id"),'from':(org.strotmann.fragDenIng.Experte.list()),'optionKey':("id"),'required':(""),'value':(angebotInstance?.experte?.id),'class':("many-to-one")],-1)
printHtmlPart(10)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1580051970000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
