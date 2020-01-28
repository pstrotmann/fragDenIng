
<%@ page import="org.strotmann.fragDenIng.Teilnehmer" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'teilnehmer.label', default: 'Teilnehmer')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-teilnehmer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-teilnehmer" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list teilnehmer">
			
				<g:if test="${teilnehmerInstance?.nickname}">
				<li class="fieldcontain">
					<span id="nickname-label" class="property-label"><g:message code="teilnehmer.nickname.label" default="Nickname" /></span>
					
						<span class="property-value" aria-labelledby="nickname-label"><g:fieldValue bean="${teilnehmerInstance}" field="nickname"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${teilnehmerInstance?.passwort}">
				<li class="fieldcontain">
					<span id="passwort-label" class="property-label"><g:message code="teilnehmer.passwort.label" default="Passwort" /></span>
					
						<span class="property-value" aria-labelledby="passwort-label"><g:fieldValue bean="${teilnehmerInstance}" field="passwort"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${teilnehmerInstance?.sprache}">
				<li class="fieldcontain">
					<span id="sprache-label" class="property-label"><g:message code="teilnehmer.sprache.label" default="Sprache" /></span>
					
						<span class="property-value" aria-labelledby="sprache-label"><g:fieldValue bean="${teilnehmerInstance}" field="sprache"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:teilnehmerInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${teilnehmerInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
