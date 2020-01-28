import org.strotmann.fragDenIng.Fragesteller
import org.strotmann.partner.adapter.Helper
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fragDenIng_fragesteller_formSave_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fragesteller/_formSave.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: fragestellerInstance, field: 'fragen', 'error'))
printHtmlPart(2)
invokeTag('message','g',7,['code':("fragesteller.fragen.label"),'default':("Fragen")],-1)
printHtmlPart(3)
for( f in (fragestellerInstance?.fragen) ) {
printHtmlPart(4)
createTagBody(2, {->
expressionOut.print(f?.encodeAsHTML())
})
invokeTag('link','g',13,['controller':("frage"),'action':("show"),'id':(f.id)],2)
printHtmlPart(5)
}
printHtmlPart(6)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'frage.label', default: 'Frage')]))
})
invokeTag('link','g',16,['controller':("frage"),'action':("create"),'params':(['fragesteller.id': fragestellerInstance?.id])],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: fragestellerInstance, field: 'nickname', 'error'))
printHtmlPart(8)
invokeTag('message','g',25,['code':("fragesteller.nickname.label"),'default':("Nickname")],-1)
printHtmlPart(9)
invokeTag('textField','g',28,['name':("nickname"),'required':(""),'value':(fragestellerInstance?.nickname)],-1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: fragestellerInstance, field: 'passwort', 'error'))
printHtmlPart(11)
invokeTag('message','g',34,['code':("fragesteller.passwort.label"),'default':("Passwort")],-1)
printHtmlPart(9)
invokeTag('textField','g',37,['name':("passwort"),'required':(""),'value':(fragestellerInstance?.passwort)],-1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: fragestellerInstance, field: 'sprache', 'error'))
printHtmlPart(12)
invokeTag('message','g',43,['code':("fragesteller.sprache.label"),'default':("Sprache")],-1)
printHtmlPart(9)
invokeTag('select','g',46,['name':("sprache"),'from':(fragestellerInstance.constraints.sprache.inList),'required':(""),'value':(fragestellerInstance?.sprache),'valueMessagePrefix':("fragesteller.sprache")],-1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: fragestellerInstance, field: 'partner', 'error'))
printHtmlPart(13)
invokeTag('message','g',52,['code':("experte.partner.label"),'default':("Fragesteller zur Auswahl")],-1)
printHtmlPart(14)
invokeTag('select','g',54,['name':("partner.id"),'from':(session.partners),'value':(new Helper ('FragDenIng','Fragesteller',fragestellerInstance.id).partnerId),'optionKey':("id"),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1579708658000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
