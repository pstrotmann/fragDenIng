
<%@ page import="org.strotmann.fragDenIng.Teilnehmer" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'teilnehmer.label', default: 'Teilnehmer')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-teilnehmer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-teilnehmer" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="nickname" title="${message(code: 'teilnehmer.nickname.label', default: 'Nickname')}" />
					
						<g:sortableColumn property="passwort" title="${message(code: 'teilnehmer.passwort.label', default: 'Passwort')}" />
					
						<g:sortableColumn property="sprache" title="${message(code: 'teilnehmer.sprache.label', default: 'Sprache')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${teilnehmerInstanceList}" status="i" var="teilnehmerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${teilnehmerInstance.id}">${fieldValue(bean: teilnehmerInstance, field: "nickname")}</g:link></td>
					
						<td>${fieldValue(bean: teilnehmerInstance, field: "passwort")}</td>
					
						<td>${fieldValue(bean: teilnehmerInstance, field: "sprache")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${teilnehmerInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
