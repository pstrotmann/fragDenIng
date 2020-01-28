<%@ page import="org.strotmann.fragDenIng.Teilnehmer" %>

<div class="fieldcontain ${hasErrors(bean: teilnehmerInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="teilnehmer.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${teilnehmerInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: teilnehmerInstance, field: 'passwort', 'error')} required">
	<label for="passwort">
		<g:message code="teilnehmer.passwort.label" default="Passwort" />
		<span class="required-indicator">*</span>
	</label>
	<g:passwordField name="passwort" required="" value="${teilnehmerInstance?.passwort}"/>

</div>


