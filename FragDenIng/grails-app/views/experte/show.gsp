<%@ page import="org.strotmann.fragDenIng.Experte" %>
<%@ page import="org.strotmann.partner.adapter.Helper" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'experte.label', default: 'Experte')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-experte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-experte" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list experte">
			
				<g:if test="${experteInstance?.qualitätsnachweis}">
				<li class="fieldcontain">
					<span id="qualitätsnachweis-label" class="property-label"><g:message code="experte.qualitätsnachweis.label" default="Qualitätsnachweis" /></span>
					
						<span class="property-value" aria-labelledby="qualitätsnachweis-label"><g:fieldValue bean="${experteInstance}" field="qualitätsnachweis"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${experteInstance?.registrierungsstatus}">
				<li class="fieldcontain">
					<span id="registrierungsstatus-label" class="property-label"><g:message code="experte.registrierungsstatus.label" default="Registrierungsstatus" /></span>
					
						<span class="property-value" aria-labelledby="registrierungsstatus-label"><g:fieldValue bean="${experteInstance}" field="registrierungsstatus"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${experteInstance?.fachgebiet}">
				<li class="fieldcontain">
					<span id="fachgebiet-label" class="property-label"><g:message code="experte.fachgebiet.label" default="Fachgebiet" /></span>
					
						<span class="property-value" aria-labelledby="fachgebiet-label"><g:fieldValue bean="${experteInstance}" field="fachgebiet"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${experteInstance?.angebote}">
				<li class="fieldcontain">
					<span id="angebote-label" class="property-label"><g:message code="experte.angebote.label" default="Angebote" /></span>
					
						<g:each in="${experteInstance.angebote}" var="f">
						<span class="property-value" aria-labelledby="angebote-label"><g:link controller="angebot" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${experteInstance?.nickname}">
				<li class="fieldcontain">
					<span id="nickname-label" class="property-label"><g:message code="experte.nickname.label" default="Nickname" /></span>
					
						<span class="property-value" aria-labelledby="nickname-label"><g:fieldValue bean="${experteInstance}" field="nickname"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${experteInstance?.passwort}">
				<li class="fieldcontain">
					<span id="passwort-label" class="property-label"><g:message code="experte.passwort.label" default="Passwort" /></span>
					
						<span class="property-value" aria-labelledby="passwort-label"><g:fieldValue bean="${experteInstance}" field="passwort"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${experteInstance?.sprache}">
				<li class="fieldcontain">
					<span id="sprache-label" class="property-label"><g:message code="experte.sprache.label" default="Sprache" /></span>
					
						<span class="property-value" aria-labelledby="sprache-label"><g:fieldValue bean="${experteInstance}" field="sprache"/></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="experteName-label" class="property-label"><g:message code="experte.experteName.label" default="Experte" /></span>
					
						<span class="property-value" aria-labelledby="experteName-label"><g:link action="toPartner" resource="${experteInstance}" >${new Helper ('FragDenIng','Experte',experteInstance.id).name}</g:link></span>
				</li>
			
			</ol>
			<g:form url="[resource:experteInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${experteInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
