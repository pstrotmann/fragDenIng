<%@ page import="org.strotmann.fragDenIng.Angebot" %>

<div class="fieldcontain ${hasErrors(bean: angebotInstance, field: 'frage', 'error')} required">
	<label for="frage">
		<g:message code="angebot.frage.label" default="Frage" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="frage" name="frage.id" from="${org.strotmann.fragDenIng.Frage.list()}" optionKey="id" required="" value="${angebotInstance?.frage?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: angebotInstance, field: 'frage.antwort', 'error')} required">
	<label for="frage">
		<g:message code="angebot.frage.label" default="Antwort" />
	</label>
	<g:textArea name="antwort" rows="5" cols="40" />

</div>

<div class="fieldcontain ${hasErrors(bean: angebotInstance, field: 'preis', 'error')} required">
	<label for="preis">
		<g:message code="angebot.preis.label" default="Preis" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="preis" value="${fieldValue(bean: angebotInstance, field: 'preis')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: angebotInstance, field: 'termin', 'error')} ">
	<label for="termin">
		<g:message code="angebot.termin.label" default="Termin" />
		
	</label>
	<g:datePicker name="termin" precision="day"  value="${angebotInstance?.termin}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: angebotInstance, field: 'akzeptiert', 'error')} ">
	<label for="akzeptiert">
		<g:message code="angebot.akzeptiert.label" default="Akzeptiert" />
		
	</label>
	<g:checkBox name="akzeptiert" value="${angebotInstance?.akzeptiert}" />

</div>

<div class="fieldcontain ${hasErrors(bean: angebotInstance, field: 'experte', 'error')} required">
	<label for="experte">
		<g:message code="angebot.experte.label" default="Experte" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="experte" name="experte.id" from="${org.strotmann.fragDenIng.Experte.list()}" optionKey="id" required="" value="${angebotInstance?.experte?.id}" class="many-to-one"/>

</div>

