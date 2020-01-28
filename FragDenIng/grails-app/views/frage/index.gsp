
<%@ page import="org.strotmann.fragDenIng.Frage" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'frage.label', default: 'Frage')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-frage" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create" params="[text: session.vorabfrage]"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-frage" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="frage.fragesteller.label" default="Fragesteller" /></th>
					
						<g:sortableColumn property="titel" title="${message(code: 'frage.titel.label', default: 'Titel')}" />
						
						<g:sortableColumn property="text" title="${message(code: 'frage.text.label', default: 'Text')}" />
						
						<th><g:message code="frage.experte.label" default="Experte" /></th>
					
						<g:sortableColumn property="antwort" title="${message(code: 'frage.antwort.label', default: 'Antwort')}" />
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${frageInstanceList}" status="i" var="frageInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${frageInstance.id}">${fieldValue(bean: frageInstance, field: "fragesteller")}</g:link></td>
						
						<td>${fieldValue(bean: frageInstance, field: "titel")}</td>
						
						<td>${fieldValue(bean: frageInstance, field: "text")}</td>
					
						<td>${fieldValue(bean: frageInstance, field: "experte")}</td>
					
						<td>${fieldValue(bean: frageInstance, field: "antwort")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${frageInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
