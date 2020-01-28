<%@ page import="org.strotmann.fragDenIng.Experte" %>
<%@ page import="org.strotmann.partner.adapter.Helper" %>


<div class="fieldcontain ${hasErrors(bean: experteInstance, field: 'qualitätsnachweis', 'error')} ">
	<label for="qualitätsnachweis">
		<g:message code="experte.qualitätsnachweis.label" default="Qualitätsnachweis" />
		
	</label>
	<g:select name="qualitätsnachweis" from="${experteInstance.constraints.qualitätsnachweis.inList}" value="${experteInstance?.qualitätsnachweis}" valueMessagePrefix="experte.qualitätsnachweis" noSelection="['': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experteInstance, field: 'registrierungsstatus', 'error')} ">
	<label for="registrierungsstatus">
		<g:message code="experte.registrierungsstatus.label" default="Registrierungsstatus" />
		
	</label>
	<g:select name="registrierungsstatus" from="${experteInstance.constraints.registrierungsstatus.inList}" value="${experteInstance?.registrierungsstatus}" valueMessagePrefix="experte.registrierungsstatus" noSelection="['': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experteInstance, field: 'fachgebiet', 'error')} ">
	<label for="fachgebiet">
		<g:message code="experte.fachgebiet.label" default="Fachgebiet" />
		
	</label>
	<g:select name="fachgebiet" from="${experteInstance.constraints.fachgebiet.inList}" value="${experteInstance?.fachgebiet}" valueMessagePrefix="experte.fachgebiet" noSelection="['': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experteInstance, field: 'angebotn', 'error')} ">
	<label for="angebote">
		<g:message code="experte.angebote.label" default="Angebote" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${experteInstance?.angebote?}" var="f">
    <li><g:link controller="angebot" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="angebot" action="create" params="['experte.id': experteInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'angebot.label', default: 'Angebot')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: experteInstance, field: 'nickname', 'error')} required">
	<label for="nickname">
		<g:message code="experte.nickname.label" default="Nickname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nickname" required="" value="${experteInstance?.nickname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experteInstance, field: 'passwort', 'error')} required">
	<label for="passwort">
		<g:message code="experte.passwort.label" default="Passwort" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="passwort" required="" value="${experteInstance?.passwort}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experteInstance, field: 'sprache', 'error')} required">
	<label for="sprache">
		<g:message code="experte.sprache.label" default="Sprache" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="sprache" from="${experteInstance.constraints.sprache.inList}" required="" value="${experteInstance?.sprache}" valueMessagePrefix="experte.sprache"/>

</div>

<div class="fieldcontain ${hasErrors(bean: experteInstance, field: 'partner', 'error')}">
	<label for="partner">
		<g:message code="experte.partner.label" default="Experten zur Auswahl" />
		</label>
		<g:select name="partner.id" from="${session.partners}" value="${new Helper ('FragDenIng','Experte',experteInstance.id).partnerId}" optionKey="id" class="many-to-one" noSelection="['null': '']"/>
</div>

