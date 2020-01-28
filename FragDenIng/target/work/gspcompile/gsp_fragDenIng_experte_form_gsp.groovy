import org.strotmann.fragDenIng.Experte
import org.strotmann.partner.adapter.Helper
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fragDenIng_experte_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/experte/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: experteInstance, field: 'qualitätsnachweis', 'error'))
printHtmlPart(2)
invokeTag('message','g',7,['code':("experte.qualitätsnachweis.label"),'default':("Qualitätsnachweis")],-1)
printHtmlPart(3)
invokeTag('select','g',10,['name':("qualitätsnachweis"),'from':(experteInstance.constraints.qualitätsnachweis.inList),'value':(experteInstance?.qualitätsnachweis),'valueMessagePrefix':("experte.qualitätsnachweis"),'noSelection':(['': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: experteInstance, field: 'registrierungsstatus', 'error'))
printHtmlPart(5)
invokeTag('message','g',16,['code':("experte.registrierungsstatus.label"),'default':("Registrierungsstatus")],-1)
printHtmlPart(3)
invokeTag('select','g',19,['name':("registrierungsstatus"),'from':(experteInstance.constraints.registrierungsstatus.inList),'value':(experteInstance?.registrierungsstatus),'valueMessagePrefix':("experte.registrierungsstatus"),'noSelection':(['': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: experteInstance, field: 'fachgebiet', 'error'))
printHtmlPart(6)
invokeTag('message','g',25,['code':("experte.fachgebiet.label"),'default':("Fachgebiet")],-1)
printHtmlPart(3)
invokeTag('select','g',28,['name':("fachgebiet"),'from':(experteInstance.constraints.fachgebiet.inList),'value':(experteInstance?.fachgebiet),'valueMessagePrefix':("experte.fachgebiet"),'noSelection':(['': ''])],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: experteInstance, field: 'angebotn', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("experte.angebote.label"),'default':("Angebote")],-1)
printHtmlPart(8)
for( f in (experteInstance?.angebote) ) {
printHtmlPart(9)
createTagBody(2, {->
expressionOut.print(f?.encodeAsHTML())
})
invokeTag('link','g',40,['controller':("angebot"),'action':("show"),'id':(f.id)],2)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'angebot.label', default: 'Angebot')]))
})
invokeTag('link','g',43,['controller':("angebot"),'action':("create"),'params':(['experte.id': experteInstance?.id])],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: experteInstance, field: 'nickname', 'error'))
printHtmlPart(13)
invokeTag('message','g',52,['code':("experte.nickname.label"),'default':("Nickname")],-1)
printHtmlPart(14)
invokeTag('textField','g',55,['name':("nickname"),'required':(""),'value':(experteInstance?.nickname)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: experteInstance, field: 'passwort', 'error'))
printHtmlPart(15)
invokeTag('message','g',61,['code':("experte.passwort.label"),'default':("Passwort")],-1)
printHtmlPart(14)
invokeTag('textField','g',64,['name':("passwort"),'required':(""),'value':(experteInstance?.passwort)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: experteInstance, field: 'sprache', 'error'))
printHtmlPart(16)
invokeTag('message','g',70,['code':("experte.sprache.label"),'default':("Sprache")],-1)
printHtmlPart(14)
invokeTag('select','g',73,['name':("sprache"),'from':(experteInstance.constraints.sprache.inList),'required':(""),'value':(experteInstance?.sprache),'valueMessagePrefix':("experte.sprache")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: experteInstance, field: 'partner', 'error'))
printHtmlPart(17)
invokeTag('message','g',79,['code':("experte.partner.label"),'default':("Experten zur Auswahl")],-1)
printHtmlPart(18)
invokeTag('select','g',81,['name':("partner.id"),'from':(session.partners),'value':(new Helper ('FragDenIng','Experte',experteInstance.id).partnerId),'optionKey':("id"),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1579797867000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
