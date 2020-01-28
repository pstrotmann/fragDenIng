<%@ page import="org.strotmann.fragDenIng.Frage" %>



<%--<div class="fieldcontain ${hasErrors(bean: frageInstance, field: 'preisAkzeptiert', 'error')} ">--%>
<%--	<label for="preisAkzeptiert">--%>
<%--		<g:message code="frage.preisAkzeptiert.label" default="Preis Akzeptiert" />--%>
<%--		--%>
<%--	</label>--%>
<%--	<g:field name="preisAkzeptiert" value="${fieldValue(bean: frageInstance, field: 'preisAkzeptiert')}"/>--%>
<%----%>
<%--</div>--%>
<%----%>
<%--<div class="fieldcontain ${hasErrors(bean: frageInstance, field: 'angebote', 'error')} ">--%>
<%--	<label for="angebot">--%>
<%--		<g:message code="frage.angebot.label" default="Angebote" />--%>
<%--		--%>
<%--	</label>--%>
<%--	<g:select id="angebot" name="angebot.id" from="${org.strotmann.fragDenIng.Angebot.list()}" optionKey="id" value="${frageInstance?.angebote?.id}" class="many-to-one" noSelection="['null': '']"/>--%>
<%----%>
<%--</div>--%>
<%----%>
<%--<div class="fieldcontain ${hasErrors(bean: frageInstance, field: 'antwort', 'error')} ">--%>
<%--	<label for="antwort">--%>
<%--		<g:message code="frage.antwort.label" default="Antwort" />--%>
<%--		--%>
<%--	</label>--%>
<%--	<g:textField name="antwort" value="${frageInstance?.antwort}"/>--%>
<%----%>
<%--</div>--%>
<%----%>
<%--<div class="fieldcontain ${hasErrors(bean: frageInstance, field: 'zeitBeantwortet', 'error')} ">--%>
<%--	<label for="zeitBeantwortet">--%>
<%--		<g:message code="frage.zeitBeantwortet.label" default="Zeit Beantwortet" />--%>
<%--		--%>
<%--	</label>--%>
<%--	<g:datePicker name="zeitBeantwortet" precision="day"  value="${frageInstance?.zeitBeantwortet}" default="none" noSelection="['': '']" />--%>
<%----%>
<%--</div>--%>

<div class="fieldcontain ${hasErrors(bean: frageInstance, field: 'fragesteller', 'error')} required">
	<label for="fragesteller">
		<g:message code="frage.fragesteller.label" default="Fragesteller" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fragesteller" name="fragesteller.id" from="${session.user?:org.strotmann.fragDenIng.Fragesteller.list()}" optionKey="id" required="" value="${frageInstance?.fragesteller?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: frageInstance, field: 'preisGeboten', 'error')} required">
	<label for="preisGeboten">
		<g:message code="frage.preisGeboten.label" default="Preis Geboten" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="preisGeboten" required="" value="${fieldValue(bean: frageInstance, field: 'preisGeboten')}" />

</div>

<div class="fieldcontain ${hasErrors(bean: frageInstance, field: 'titel', 'error')} required">
	<label for="titel">
		<g:message code="frage.titel.label" default="Titel" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="titel" required="" value="${frageInstance?.titel}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: frageInstance, field: 'text', 'error')} required">
	<label for="text">
		<g:message code="frage.text.label" default="Text" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="text" required="" value="${frageInstance?.text}" rows="4" cols="80"/>

</div>

<div class="fieldcontain ${hasErrors(bean: frageInstance, field: 'zeitGestellt', 'error')} required">
	<label for="zeitGestellt">
		<g:message code="frage.zeitGestellt.label" default="Zeit Gestellt" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="zeitGestellt" precision="day"  value="${frageInstance?.zeitGestellt}"  />

</div>

