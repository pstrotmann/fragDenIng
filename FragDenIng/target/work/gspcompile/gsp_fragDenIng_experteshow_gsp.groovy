import org.strotmann.fragDenIng.Experte
import org.strotmann.partner.adapter.Helper
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_fragDenIng_experteshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/experte/show.gsp" }
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
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'experte.label', default: 'Experte'))],-1)
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
printHtmlPart(9)
invokeTag('message','g',21,['code':("default.show.label"),'args':([entityName])],-1)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (experteInstance?.qualitätsnachweis)) {
printHtmlPart(14)
invokeTag('message','g',29,['code':("experte.qualitätsnachweis.label"),'default':("Qualitätsnachweis")],-1)
printHtmlPart(15)
invokeTag('fieldValue','g',31,['bean':(experteInstance),'field':("qualitätsnachweis")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (experteInstance?.registrierungsstatus)) {
printHtmlPart(18)
invokeTag('message','g',38,['code':("experte.registrierungsstatus.label"),'default':("Registrierungsstatus")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',40,['bean':(experteInstance),'field':("registrierungsstatus")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (experteInstance?.fachgebiet)) {
printHtmlPart(20)
invokeTag('message','g',47,['code':("experte.fachgebiet.label"),'default':("Fachgebiet")],-1)
printHtmlPart(21)
invokeTag('fieldValue','g',49,['bean':(experteInstance),'field':("fachgebiet")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (experteInstance?.angebote)) {
printHtmlPart(22)
invokeTag('message','g',56,['code':("experte.angebote.label"),'default':("Angebote")],-1)
printHtmlPart(23)
for( f in (experteInstance.angebote) ) {
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(f?.encodeAsHTML())
})
invokeTag('link','g',59,['controller':("angebot"),'action':("show"),'id':(f.id)],4)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(17)
if(true && (experteInstance?.nickname)) {
printHtmlPart(27)
invokeTag('message','g',67,['code':("experte.nickname.label"),'default':("Nickname")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',69,['bean':(experteInstance),'field':("nickname")],-1)
printHtmlPart(16)
}
printHtmlPart(29)
if(true && (experteInstance?.passwort)) {
printHtmlPart(30)
invokeTag('message','g',76,['code':("experte.passwort.label"),'default':("Passwort")],-1)
printHtmlPart(31)
invokeTag('fieldValue','g',78,['bean':(experteInstance),'field':("passwort")],-1)
printHtmlPart(16)
}
printHtmlPart(29)
if(true && (experteInstance?.sprache)) {
printHtmlPart(32)
invokeTag('message','g',85,['code':("experte.sprache.label"),'default':("Sprache")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',87,['bean':(experteInstance),'field':("sprache")],-1)
printHtmlPart(16)
}
printHtmlPart(34)
invokeTag('message','g',93,['code':("experte.experteName.label"),'default':("Experte")],-1)
printHtmlPart(35)
createTagBody(2, {->
expressionOut.print(new Helper ('FragDenIng','Experte',experteInstance.id).name)
})
invokeTag('link','g',95,['action':("toPartner"),'resource':(experteInstance)],2)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(37)
createTagBody(3, {->
invokeTag('message','g',101,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',101,['class':("edit"),'action':("edit"),'resource':(experteInstance)],3)
printHtmlPart(38)
invokeTag('actionSubmit','g',102,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(39)
})
invokeTag('form','g',104,['url':([resource:experteInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',106,[:],1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1579797963000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
