
<%@ page import="org.strotmann.fragDenIng.Angebot" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'angebot.label', default: 'Angebot')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-angebot" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-angebot" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list angebot">
			
				<g:if test="${angebotInstance?.frage}">
				<li class="fieldcontain">
					<span id="frage-label" class="property-label"><g:message code="angebot.frage.label" default="Frage" /></span>
					
						<span class="property-value" aria-labelledby="frage-label"><g:link controller="frage" action="show" id="${angebotInstance?.frage?.id}">${angebotInstance?.frage?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${angebotInstance?.preis}">
				<li class="fieldcontain">
					<span id="preis-label" class="property-label"><g:message code="angebot.preis.label" default="Preis" /></span>
					
						<span class="property-value" aria-labelledby="preis-label"><g:fieldValue bean="${angebotInstance}" field="preis"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${angebotInstance?.termin}">
				<li class="fieldcontain">
					<span id="termin-label" class="property-label"><g:message code="angebot.termin.label" default="Termin" /></span>
					
						<span class="property-value" aria-labelledby="termin-label"><g:formatDate date="${angebotInstance?.termin}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${angebotInstance?.akzeptiert}">
				<li class="fieldcontain">
					<span id="akzeptiert-label" class="property-label"><g:message code="angebot.akzeptiert.label" default="Akzeptiert" /></span>
					
						<span class="property-value" aria-labelledby="akzeptiert-label"><g:formatBoolean boolean="${angebotInstance?.akzeptiert}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${angebotInstance?.experte}">
				<li class="fieldcontain">
					<span id="experte-label" class="property-label"><g:message code="angebot.experte.label" default="Experte" /></span>
					
						<span class="property-value" aria-labelledby="experte-label"><g:link controller="experte" action="show" id="${angebotInstance?.experte?.id}">${angebotInstance?.experte?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:angebotInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${angebotInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
