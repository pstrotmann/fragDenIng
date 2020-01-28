import org.strotmann.fragDenIng.Teilnehmer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fragDenIng_teilnehmer_form2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/teilnehmer/_form2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: teilnehmerInstance, field: 'name', 'error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("teilnehmer.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',8,['name':("name"),'required':(""),'value':(teilnehmerInstance?.name)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: teilnehmerInstance, field: 'passwort', 'error'))
printHtmlPart(4)
invokeTag('message','g',14,['code':("teilnehmer.passwort.label"),'default':("Passwort")],-1)
printHtmlPart(2)
invokeTag('passwordField','g',17,['name':("passwort"),'required':(""),'value':(teilnehmerInstance?.passwort)],-1)
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1579706955000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
