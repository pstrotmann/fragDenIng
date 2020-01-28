
<%@ page import="org.strotmann.fragDenIng.Angebot" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'angebot.label', default: 'Angebot')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-angebot" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-angebot" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="angebot.frage.label" default="Frage" /></th>
					
						<g:sortableColumn property="preis" title="${message(code: 'angebot.preis.label', default: 'Preis')}" />
					
						<g:sortableColumn property="termin" title="${message(code: 'angebot.termin.label', default: 'Termin')}" />
					
						<g:sortableColumn property="akzeptiert" title="${message(code: 'angebot.akzeptiert.label', default: 'Akzeptiert')}" />
					
						<th><g:message code="angebot.experte.label" default="Experte" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${angebotInstanceList}" status="i" var="angebotInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${angebotInstance.id}">${fieldValue(bean: angebotInstance, field: "frage")}</g:link></td>
					
						<td>${fieldValue(bean: angebotInstance, field: "preis")}</td>
					
						<td><g:formatDate date="${angebotInstance.termin}" /></td>
					
						<td><g:formatBoolean boolean="${angebotInstance.akzeptiert}" /></td>
					
						<td>${fieldValue(bean: angebotInstance, field: "experte")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${angebotInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
