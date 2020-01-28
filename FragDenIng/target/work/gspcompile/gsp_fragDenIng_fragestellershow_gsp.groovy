import org.strotmann.fragDenIng.Fragesteller
import org.strotmann.partner.adapter.Helper
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fragDenIng_fragestellershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fragesteller/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'fragesteller.label', default: 'Fragesteller'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',9,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
invokeTag('message','g',12,['code':("default.link.skip.label"),'default':("Skip to content&hellip;")],-1)
printHtmlPart(5)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(6)
invokeTag('message','g',15,['code':("default.home.label")],-1)
printHtmlPart(7)
createTagBody(2, {->
invokeTag('message','g',16,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',16,['class':("list"),'action':("index")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',17,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',17,['class':("create"),'action':("create")],2)
printHtmlPart(8)
createTagBody(2, {->
invokeTag('message','g',18,['code':("default.login.label"),'args':([entityName]),'default':("login")],-1)
})
invokeTag('link','g',18,['class':("create"),'controller':("teilnehmer"),'action':("login")],2)
printHtmlPart(9)
invokeTag('message','g',22,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (fragestellerInstance?.fragen)) {
printHtmlPart(14)
invokeTag('message','g',30,['code':("fragesteller.fragen.label"),'default':("Fragen")],-1)
printHtmlPart(15)
for( f in (fragestellerInstance.fragen) ) {
printHtmlPart(16)
createTagBody(4, {->
expressionOut.print(f?.encodeAsHTML())
})
invokeTag('link','g',33,['controller':("frage"),'action':("show"),'id':(f.id)],4)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (fragestellerInstance?.nickname)) {
printHtmlPart(20)
invokeTag('message','g',41,['code':("fragesteller.nickname.label"),'default':("Nickname")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',43,['bean':(fragestellerInstance),'field':("nickname")],-1)
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (fragestellerInstance?.passwort)) {
printHtmlPart(24)
invokeTag('message','g',50,['code':("fragesteller.passwort.label"),'default':("Passwort")],-1)
printHtmlPart(25)
invokeTag('fieldValue','g',52,['bean':(fragestellerInstance),'field':("passwort")],-1)
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (fragestellerInstance?.sprache)) {
printHtmlPart(26)
invokeTag('message','g',59,['code':("fragesteller.sprache.label"),'default':("Sprache")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',61,['bean':(fragestellerInstance),'field':("sprache")],-1)
printHtmlPart(22)
}
printHtmlPart(28)
invokeTag('message','g',67,['code':("fragesteller.fragestellerName.label"),'default':("Partnerdaten")],-1)
printHtmlPart(29)
createTagBody(2, {->
expressionOut.print(new Helper ('FragDenIng','Fragesteller',fragestellerInstance.id).name)
})
invokeTag('link','g',69,['action':("toPartner"),'resource':(fragestellerInstance)],2)
printHtmlPart(30)
createTagBody(2, {->
printHtmlPart(31)
createTagBody(3, {->
invokeTag('message','g',75,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',75,['class':("edit"),'action':("edit"),'resource':(fragestellerInstance)],3)
printHtmlPart(32)
invokeTag('actionSubmit','g',76,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(33)
})
invokeTag('form','g',78,['url':([resource:fragestellerInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(34)
})
invokeTag('captureBody','sitemesh',80,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1580037951000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
