<%@ page import="org.strotmann.fragDenIng.Fragesteller" %>
<%@ page import="org.strotmann.partner.adapter.Helper" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'fragesteller.label', default: 'Fragesteller')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-fragesteller" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" controller= "teilnehmer" action="login"><g:message code="default.login.label" args="[entityName]" default="login"/></g:link></li>
			</ul>
		</div>
		<div id="show-fragesteller" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list fragesteller">
			
				<g:if test="${fragestellerInstance?.fragen}">
				<li class="fieldcontain">
					<span id="fragen-label" class="property-label"><g:message code="fragesteller.fragen.label" default="Fragen" /></span>
					
						<g:each in="${fragestellerInstance.fragen}" var="f">
						<span class="property-value" aria-labelledby="fragen-label"><g:link controller="frage" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${fragestellerInstance?.nickname}">
				<li class="fieldcontain">
					<span id="nickname-label" class="property-label"><g:message code="fragesteller.nickname.label" default="Nickname" /></span>
					
						<span class="property-value" aria-labelledby="nickname-label"><g:fieldValue bean="${fragestellerInstance}" field="nickname"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${fragestellerInstance?.passwort}">
				<li class="fieldcontain">
					<span id="passwort-label" class="property-label"><g:message code="fragesteller.passwort.label" default="Passwort" /></span>
					
						<span class="property-value" aria-labelledby="passwort-label"><g:fieldValue bean="${fragestellerInstance}" field="passwort"/></span>
					
				</li>
				</g:if>
				
				<g:if test="${fragestellerInstance?.sprache}">
				<li class="fieldcontain">
					<span id="sprache-label" class="property-label"><g:message code="fragesteller.sprache.label" default="Sprache" /></span>
					
						<span class="property-value" aria-labelledby="sprache-label"><g:fieldValue bean="${fragestellerInstance}" field="sprache"/></span>
					
				</li>
				</g:if>
				
				<li class="fieldcontain">
					<span id="fragestellerName-label" class="property-label"><g:message code="fragesteller.fragestellerName.label" default="Partnerdaten" /></span>
					
						<span class="property-value" aria-labelledby="fragestellerName-label"><g:link action="toPartner" resource="${fragestellerInstance}" >${new Helper ('FragDenIng','Fragesteller',fragestellerInstance.id).name}</g:link></span>
				</li>
			
			</ol>
			<g:form url="[resource:fragestellerInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${fragestellerInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
