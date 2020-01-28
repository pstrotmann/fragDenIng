<%@ page import="org.strotmann.fragDenIng.Fragesteller" %>
<%@ page import="org.strotmann.partner.adapter.Helper" %>


<div class="fieldcontain ${hasErrors(bean: fragestellerInstance, field: 'nickname', 'error')} required">
	<label for="nickname">
		<g:message code="fragesteller.nickname.label" default="Nickname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nickname" required="" value="${fragestellerInstance?.nickname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: fragestellerInstance, field: 'passwort', 'error')} ">
	<label for="passwort">
		<g:message code="fragesteller.passwort.label" default="Passwort" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="passwort" required="" value="${fragestellerInstance?.passwort}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: fragestellerInstance, field: 'sprache', 'error')} ">
	<label for="sprache">
		<g:message code="fragesteller.sprache.label" default="Sprache" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="sprache" from="${fragestellerInstance.constraints.sprache.inList}" required="" value="${fragestellerInstance?.sprache}" valueMessagePrefix="fragesteller.sprache" />

</div>

<%--<div class="fieldcontain ${hasErrors(bean: fragestellerInstance, field: 'fragen', 'error')} ">--%>
<%--	<label for="fragen">--%>
<%--		<g:message code="fragesteller.fragen.label" default="Fragen" />--%>
<%--		--%>
<%--	</label>--%>
<%--	--%>
<%--<ul class="one-to-many">--%>
<%--<g:each in="${fragestellerInstance?.fragen?}" var="f">--%>
<%--    <li><g:link controller="frage" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>--%>
<%--</g:each>--%>
<%--<li class="add">--%>
<%--<g:link controller="frage" action="create" params="['fragesteller.id': fragestellerInstance?.id, text: session.vorabfrage]">${message(code: 'default.add.label', args: [message(code: 'frage.label', default: 'Frage')])}</g:link>--%>
<%--</li>--%>
<%--</ul>--%>
<%----%>
<%--</div>--%>

<g:if test="${!flash.createMode}">
<div class="fieldcontain ${hasErrors(bean: fragestellerInstance, field: 'partner', 'error')}">
	<label for="partner">
		<g:message code="experte.partner.label" default="Partner zur Auswahl" />
		</label>
		<g:select name="partner.id" from="${session.partners}" value="${new Helper ('FragDenIng','Fragesteller',fragestellerInstance.id).partnerId}" optionKey="id" class="many-to-one" noSelection="['null': '']"/>
</div>
</g:if>
