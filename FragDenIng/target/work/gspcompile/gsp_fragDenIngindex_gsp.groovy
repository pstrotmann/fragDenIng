import org.strotmann.fragDenIng.Frage
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fragDenIngindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',85,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
invokeTag('message','g',87,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',102,['controller':("Fragesteller")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',103,['controller':("Experte")],2)
printHtmlPart(8)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',104,['controller':("Frage")],2)
printHtmlPart(8)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',105,['controller':("Angebot")],2)
printHtmlPart(8)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',106,['controller':("Teilnehmer"),'action':("login")],2)
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
expressionOut.print(hasErrors(bean: frageInstance, field: 'text', 'error'))
printHtmlPart(15)
invokeTag('textArea','g',120,['name':("vorabfrage"),'value':(frageInstance?.text),'rows':("4"),'cols':("80")],-1)
printHtmlPart(16)
invokeTag('submitButton','g',123,['name':("create"),'class':("save"),'value':(message(code: 'default.button.fragen.label', default: 'Frage stellen'))],-1)
printHtmlPart(17)
})
invokeTag('form','g',125,['name':("myForm"),'url':([controller:'vorabfrage'])],2)
printHtmlPart(18)
invokeTag('message','g',132,['code':("frage.fragesteller.label"),'default':("Fragesteller")],-1)
printHtmlPart(19)
invokeTag('message','g',134,['code':("frage.titel.label"),'default':("Titel")],-1)
printHtmlPart(19)
invokeTag('message','g',136,['code':("frage.text.label"),'default':("Text")],-1)
printHtmlPart(20)
invokeTag('message','g',138,['code':("frage.experte.label"),'default':("Experte")],-1)
printHtmlPart(19)
invokeTag('message','g',140,['code':("frage.antwort.label"),'default':("Antwort")],-1)
printHtmlPart(21)
loop:{
int i = 0
for( frageInstance in (Frage.list()) ) {
printHtmlPart(22)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(23)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: frageInstance, field: "fragesteller"))
})
invokeTag('link','g',148,['controller':("frage"),'action':("show"),'id':(frageInstance.id)],3)
printHtmlPart(24)
expressionOut.print(fieldValue(bean: frageInstance, field: "titel"))
printHtmlPart(24)
expressionOut.print(fieldValue(bean: frageInstance, field: "text"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: frageInstance, field: "experte"))
printHtmlPart(25)
expressionOut.print(fieldValue(bean: frageInstance, field: "antwort"))
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',165,[:],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1580146836000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
