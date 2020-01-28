import org.strotmann.fragDenIng.Frage
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fragDenIngindexAlt_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/indexAlt.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("text/html; charset=ISO-8859-1"),'http-equiv':("content-type")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(hasErrors(bean: frageInstance, field: 'text', 'error'))
printHtmlPart(8)
invokeTag('textArea','g',26,['name':("vorabfrage"),'value':(frageInstance?.text),'rows':("4"),'cols':("80")],-1)
printHtmlPart(9)
invokeTag('submitButton','g',29,['name':("create"),'class':("save"),'value':(message(code: 'default.button.fragen.label', default: 'Frage stellen'))],-1)
printHtmlPart(10)
})
invokeTag('form','g',31,['name':("myForm"),'url':([controller:'vorabfrage'])],2)
printHtmlPart(11)
invokeTag('message','g',65,['code':("frage.fragesteller.label"),'default':("Fragesteller")],-1)
printHtmlPart(12)
invokeTag('message','g',67,['code':("frage.titel.label"),'default':("Titel")],-1)
printHtmlPart(12)
invokeTag('message','g',69,['code':("frage.text.label"),'default':("Text")],-1)
printHtmlPart(13)
invokeTag('message','g',71,['code':("frage.experte.label"),'default':("Experte")],-1)
printHtmlPart(12)
invokeTag('message','g',73,['code':("frage.antwort.label"),'default':("Antwort")],-1)
printHtmlPart(14)
loop:{
int i = 0
for( frageInstance in (Frage.list()) ) {
printHtmlPart(15)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(16)
createTagBody(3, {->
expressionOut.print(fieldValue(bean: frageInstance, field: "fragesteller"))
})
invokeTag('link','g',81,['controller':("frage"),'action':("show"),'id':(frageInstance.id)],3)
printHtmlPart(17)
expressionOut.print(fieldValue(bean: frageInstance, field: "titel"))
printHtmlPart(17)
expressionOut.print(fieldValue(bean: frageInstance, field: "text"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: frageInstance, field: "experte"))
printHtmlPart(18)
expressionOut.print(fieldValue(bean: frageInstance, field: "antwort"))
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',102,['controller':("Fragesteller")],2)
printHtmlPart(22)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',103,['controller':("Experte")],2)
printHtmlPart(22)
createClosureForHtmlPart(24, 2)
invokeTag('link','g',104,['controller':("Frage")],2)
printHtmlPart(22)
createClosureForHtmlPart(25, 2)
invokeTag('link','g',105,['controller':("Angebot")],2)
printHtmlPart(22)
createClosureForHtmlPart(26, 2)
invokeTag('link','g',106,['controller':("Teilnehmer"),'action':("login")],2)
printHtmlPart(27)
})
invokeTag('captureBody','sitemesh',109,['style':("height: 47px; color: rgb(0, 0, 0);"),'alink':("#ee0000"),'link':("#0000ee"),'vlink':("#551a8b")],1)
printHtmlPart(28)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1580041973000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
