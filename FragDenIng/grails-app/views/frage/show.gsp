
<%@ page import="org.strotmann.fragDenIng.Frage" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'frage.label', default: 'Frage')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-frage" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-frage" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list frage">
			
				<g:if test="${frageInstance?.preisAkzeptiert}">
				<li class="fieldcontain">
					<span id="preisAkzeptiert-label" class="property-label"><g:message code="frage.preisAkzeptiert.label" default="Preis Akzeptiert" /></span>
					
						<span class="property-value" aria-labelledby="preisAkzeptiert-label"><g:fieldValue bean="${frageInstance}" field="preisAkzeptiert"/></span>
											
				</li>
				</g:if>
			
				<g:if test="${frageInstance?.angebote}">
				<li class="fieldcontain">
					<span id="angebot-label" class="property-label"><g:message code="frage.angebot.label" default="Angebote" /></span>
					
						<span class="property-value" aria-labelledby="angebot-label"><g:message code="angebot.fragen.label" default="Angebote" /></span>
				
						<g:each in="${frageInstance.angebote}" var="a">
							<span class="property-value" aria-labelledby="angebot-label"><g:link controller="angebot" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>	
				</li>
				</g:if>
			
				<g:if test="${frageInstance?.antwort}">
				<li class="fieldcontain">
					<span id="antwort-label" class="property-label"><g:message code="frage.antwort.label" default="Antwort" /></span>
					
						<span class="property-value" aria-labelledby="antwort-label"><g:fieldValue bean="${frageInstance}" field="antwort"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${frageInstance?.zeitBeantwortet}">
				<li class="fieldcontain">
					<span id="zeitBeantwortet-label" class="property-label"><g:message code="frage.zeitBeantwortet.label" default="Zeit Beantwortet" /></span>
					
						<span class="property-value" aria-labelledby="zeitBeantwortet-label"><g:formatDate date="${frageInstance?.zeitBeantwortet}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${frageInstance?.fragesteller}">
				<li class="fieldcontain">
					<span id="fragesteller-label" class="property-label"><g:message code="frage.fragesteller.label" default="Fragesteller" /></span>
					
						<span class="property-value" aria-labelledby="fragesteller-label"><g:link controller="fragesteller" action="show" id="${frageInstance?.fragesteller?.id}">${frageInstance?.fragesteller?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${frageInstance?.preisGeboten}">
				<li class="fieldcontain">
					<span id="preisGeboten-label" class="property-label"><g:message code="frage.preisGeboten.label" default="Preis Geboten" /></span>
					
						<span class="property-value" aria-labelledby="preisGeboten-label"><g:fieldValue bean="${frageInstance}" field="preisGeboten"/></span>
					
				</li>
				</g:if>
										
				<g:if test="${frageInstance?.titel}">
				<li class="fieldcontain">
					<span id="titel-label" class="property-label"><g:message code="frage.titel.label" default="Titel" /></span>
					
						<span class="property-value" aria-labelledby="titel-label"><g:fieldValue bean="${frageInstance}" field="titel"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${frageInstance?.text}">
				<li class="fieldcontain">
					<span id="text-label" class="property-label"><g:message code="frage.text.label" default="Text" /></span>
					
						<span class="property-value" aria-labelledby="text-label"><g:fieldValue bean="${frageInstance}" field="text"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${frageInstance?.zeitGestellt}">
				<li class="fieldcontain">
					<span id="zeitGestellt-label" class="property-label"><g:message code="frage.zeitGestellt.label" default="Zeit Gestellt" /></span>
					
						<span class="property-value" aria-labelledby="zeitGestellt-label"><g:formatDate date="${frageInstance?.zeitGestellt}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:frageInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${frageInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
