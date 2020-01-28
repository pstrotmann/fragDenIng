
<%@ page import="org.strotmann.fragDenIng.Experte" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'experte.label', default: 'Experte')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-experte" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-experte" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="nickname" title="${message(code: 'experte.nickname.label', default: 'Nickname')}" />
					
						<g:sortableColumn property="registrierungsstatus" title="${message(code: 'experte.registrierungsstatus.label', default: 'Registrierungsstatus')}" />
					
						<g:sortableColumn property="fachgebiet" title="${message(code: 'experte.fachgebiet.label', default: 'Fachgebiet')}" />
						
						<g:sortableColumn property="qualitätsnachweis" title="${message(code: 'experte.qualitätsnachweis.label', default: 'Qualitätsnachweis')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${experteInstanceList}" status="i" var="experteInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${experteInstance.id}">${fieldValue(bean: experteInstance, field: "nickname")}</g:link></td>
					
						<td>${fieldValue(bean: experteInstance, field: "registrierungsstatus")}</td>
					
						<td>${fieldValue(bean: experteInstance, field: "fachgebiet")}</td>
					
						<td>${fieldValue(bean: experteInstance, field: "qualitätsnachweis")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${experteInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
