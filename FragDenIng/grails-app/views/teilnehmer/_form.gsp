<%@ page import="org.strotmann.fragDenIng.Teilnehmer" %>



<div class="fieldcontain ${hasErrors(bean: teilnehmerInstance, field: 'nickname', 'error')} required">
	<label for="nickname">
		<g:message code="teilnehmer.nickname.label" default="Nickname" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nickname" required="" value="${teilnehmerInstance?.nickname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: teilnehmerInstance, field: 'passwort', 'error')} required">
	<label for="passwort">
		<g:message code="teilnehmer.passwort.label" default="Passwort" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="passwort" required="" value="${teilnehmerInstance?.passwort}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: teilnehmerInstance, field: 'sprache', 'error')} required">
	<label for="sprache">
		<g:message code="teilnehmer.sprache.label" default="Sprache" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="sprache" from="${teilnehmerInstance.constraints.sprache.inList}" required="" value="${teilnehmerInstance?.sprache}" valueMessagePrefix="teilnehmer.sprache"/>

</div>

