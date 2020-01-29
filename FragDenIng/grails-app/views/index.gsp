<%@ page import="org.strotmann.fragDenIng.Frage" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>AskAnEngineer</title>
		<style type="text/css" media="screen">
			#status {
				background-color: #eee;
				border: .2em solid #fff;
				margin: 2em 2em 1em;
				padding: 1em;
				width: 12em;
				float: left;
				-moz-box-shadow: 0px 0px 1.25em #ccc;
				-webkit-box-shadow: 0px 0px 1.25em #ccc;
				box-shadow: 0px 0px 1.25em #ccc;
				-moz-border-radius: 0.6em;
				-webkit-border-radius: 0.6em;
				border-radius: 0.6em;
			}

			.ie6 #status {
				display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
			}

			#status ul {
				font-size: 0.9em;
				list-style-type: none;
				margin-bottom: 0.6em;
				padding: 0;
			}

			#status li {
				line-height: 1.3;
			}

			#status h1 {
				text-transform: uppercase;
				font-size: 1.1em;
				margin: 0 0 0.3em;
			}
			

			#page-body {
				margin: 2em 1em 1.25em 18em;
			}

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				line-height: 1.5;
				margin: 0.25em 0;
			}

			#controller-list ul {
				list-style-position: inside;
			}

			#controller-list li {
				line-height: 1.3;
				list-style-position: inside;
				margin: 0.25em 0;
			}

			@media screen and (max-width: 480px) {
				#status {
					display: none;
				}

				#page-body {
					margin: 0 1em 1em;
				}

				#page-body h1 {
					margin-top: 0;
				}
			}
		</style>
	</head>
	<body>
		<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="status" role="complementary">
			<h1>Fachgebiete</h1>
			<table>
			  <tbody>
			      <tr><td>Maschinenbau</td></tr>
			      <tr><td>CAD Bearbeitung</td></tr>
			      <tr><td>Chemieingenieurwesen</td></tr>
			      <tr><td>Verfahrenstechnik</td></tr>
			      <tr><td>Komponentenberechnung</td></tr>
			      <tr><td>Elektrotechnik</td></tr>
			    </tbody>
			</table>
			<h1>Funktionen</h1>
			<ul>
				<li class="controller"><g:link controller="Fragesteller">Fragesteller registrieren</g:link></li>
                <li class="controller"><g:link controller="Experte">Experten registrieren</g:link></li>
                <li class="controller"><g:link controller="Frage">Frage formulieren</g:link></li>
                <li class="controller"><g:link controller="Angebot">Angebot abgeben</g:link></li>
                <li class="controller"><g:link controller="Teilnehmer" action="login" >Login</g:link></li>
			</ul>
		</div>
		
		<div id="page-body" role="main">
			<h1>Welcome to AskAnEngineer</h1>
			<p>Sie stellen ihre Projektanfrage kostenlos und unverbindlich an unsere 100% geprüften Ingenieure.<br>
				Sie erhalten eine kostenfreie Erstberatung und ein unverbindliches Angebot zur Bearbeitung ihres Projektes von den Ingenieurexperten.<br>
				Ihr Projekt wird online inklusive modernstem Projektmanagement abgewickelt, jederzeit transparent und einsichtig.<br>
				Keine unnötigen vor-Ort Meetings, kein Papierkrieg, nur effiziente und kompetente Ingenieurskunst! Das ist <span style="color: rgb(72, 128, 44);"><g:link controller="content" action="soFunktioniert">www.ask-an-engineer.com</g:link></span><br></p>
		</div>
		<div>
			<g:form name="myForm" url="[controller:'vorabfrage']">
				<div class="fieldcontain ${hasErrors(bean: frageInstance, field: 'text', 'error')} required">
					<g:textArea name="vorabfrage" value="${frageInstance?.text}" rows="4" cols="80"/>
				</div>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.fragen.label', default: 'Frage stellen')}" />
				</fieldset>
			</g:form>
		</div>
		<div>
			<table>
				<thead>
						<tr>
						
							<th><g:message code="frage.fragesteller.label" default="Fragesteller" /></th>
							
							<th><g:message code="frage.titel.label" default="Titel" /></th>
							
							<th><g:message code="frage.text.label" default="Text" /></th>
						
							<th><g:message code="frage.experte.label" default="Experte" /></th>
							
							<th><g:message code="frage.antwort.label" default="Antwort" /></th>
						
						</tr>
				</thead>
				<tbody>
					<g:each in="${Frage.list()}" status="i" var="frageInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						
							<td><g:link controller="frage" action="show" id="${frageInstance.id}">${fieldValue(bean: frageInstance, field: "fragesteller")}</g:link></td>
							
							<td>${fieldValue(bean: frageInstance, field: "titel")}</td>
							
							<td>${fieldValue(bean: frageInstance, field: "text")}</td>
						
							<td>${fieldValue(bean: frageInstance, field: "experte")}</td>
						
							<td>${fieldValue(bean: frageInstance, field: "antwort")}</td>
						
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
		
		
	</body>
</html>
