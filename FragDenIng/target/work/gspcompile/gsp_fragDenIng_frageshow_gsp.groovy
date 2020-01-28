import org.strotmann.fragDenIng.Frage
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fragDenIng_frageshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/frage/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'frage.label', default: 'Frage'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',11,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',14,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',15,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',15,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("create"),'action':("create")],2)
printHtmlPart(9)
invokeTag('message','g',20,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (frageInstance?.preisAkzeptiert)) {
printHtmlPart(14)
invokeTag('message','g',28,['code':("frage.preisAkzeptiert.label"),'default':("Preis Akzeptiert")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',30,['bean':(frageInstance),'field':("preisAkzeptiert")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (frageInstance?.angebote)) {
printHtmlPart(18)
invokeTag('message','g',37,['code':("frage.angebot.label"),'default':("Angebote")],-1)
printHtmlPart(19)
invokeTag('message','g',39,['code':("angebot.fragen.label"),'default':("Angebote")],-1)
printHtmlPart(20)
for( a in (frageInstance.angebote) ) {
printHtmlPart(21)
createTagBody(4, {->
expressionOut.print(a?.encodeAsHTML())
})
invokeTag('link','g',42,['controller':("angebot"),'action':("show"),'id':(a.id)],4)
printHtmlPart(22)
}
printHtmlPart(23)
}
printHtmlPart(17)
if(true && (frageInstance?.antwort)) {
printHtmlPart(24)
invokeTag('message','g',49,['code':("frage.antwort.label"),'default':("Antwort")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',51,['bean':(frageInstance),'field':("antwort")],-1)
printHtmlPart(26)
}
printHtmlPart(17)
if(true && (frageInstance?.zeitBeantwortet)) {
printHtmlPart(27)
invokeTag('message','g',58,['code':("frage.zeitBeantwortet.label"),'default':("Zeit Beantwortet")],-1)
printHtmlPart(28)
invokeTag('formatDate','g',60,['date':(frageInstance?.zeitBeantwortet)],-1)
printHtmlPart(26)
}
printHtmlPart(17)
if(true && (frageInstance?.fragesteller)) {
printHtmlPart(29)
invokeTag('message','g',67,['code':("frage.fragesteller.label"),'default':("Fragesteller")],-1)
printHtmlPart(30)
createTagBody(3, {->
expressionOut.print(frageInstance?.fragesteller?.encodeAsHTML())
})
invokeTag('link','g',69,['controller':("fragesteller"),'action':("show"),'id':(frageInstance?.fragesteller?.id)],3)
printHtmlPart(26)
}
printHtmlPart(17)
if(true && (frageInstance?.preisGeboten)) {
printHtmlPart(31)
invokeTag('message','g',76,['code':("frage.preisGeboten.label"),'default':("Preis Geboten")],-1)
printHtmlPart(32)
invokeTag('fieldValue','g',78,['bean':(frageInstance),'field':("preisGeboten")],-1)
printHtmlPart(26)
}
printHtmlPart(33)
if(true && (frageInstance?.titel)) {
printHtmlPart(34)
invokeTag('message','g',85,['code':("frage.titel.label"),'default':("Titel")],-1)
printHtmlPart(35)
invokeTag('fieldValue','g',87,['bean':(frageInstance),'field':("titel")],-1)
printHtmlPart(26)
}
printHtmlPart(36)
if(true && (frageInstance?.text)) {
printHtmlPart(37)
invokeTag('message','g',94,['code':("frage.text.label"),'default':("Text")],-1)
printHtmlPart(38)
invokeTag('fieldValue','g',96,['bean':(frageInstance),'field':("text")],-1)
printHtmlPart(26)
}
printHtmlPart(17)
if(true && (frageInstance?.zeitGestellt)) {
printHtmlPart(39)
invokeTag('message','g',103,['code':("frage.zeitGestellt.label"),'default':("Zeit Gestellt")],-1)
printHtmlPart(40)
invokeTag('formatDate','g',105,['date':(frageInstance?.zeitGestellt)],-1)
printHtmlPart(26)
}
printHtmlPart(41)
createTagBody(2, {->
printHtmlPart(42)
createTagBody(3, {->
invokeTag('message','g',113,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',113,['class':("edit"),'action':("edit"),'resource':(frageInstance)],3)
printHtmlPart(43)
invokeTag('actionSubmit','g',114,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(44)
})
invokeTag('form','g',116,['url':([resource:frageInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(45)
})
invokeTag('captureBody','sitemesh',118,[:],1)
printHtmlPart(46)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1580053620000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
