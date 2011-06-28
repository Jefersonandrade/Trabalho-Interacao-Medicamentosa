<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="domainModel.Reacao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link  rel="StyleSheet" type="text/css" href="estilo.css" media="screen"/>
<title>Editar Reacao</title>
</head>
<body>
<table border="2px solid gray" >
<tr>
	<td>
		<h2 align="center">Interacoes Medicamentosas</h2>
	</td>
</tr>

<tr>
<td>
<ul id="menu">
	<li>
		<a href="http://localhost:8080/InteracoesMedicamentosas/PrincipiosAtivos"> Cadastrar Principio Ativo </a>
	</li>
	<li>
		<a href="http://localhost:8080/InteracoesMedicamentosas/Reacoes"> Cadastrar Reacao </a>
	</li>
	<li>
		<a href="http://localhost:8080/InteracoesMedicamentosas/Medicamentos"> Cadastrar Medicamento </a>
	</li>
	<li>
		<a href="http://localhost:8080/InteracoesMedicamentosas/Fabricantes"> Cadastrar Fabricante </a>
	</li>
</ul>
</td>
</tr>
<tr>
<td>
	<%
	Reacao reacao = (Reacao) request.getAttribute("reacao");
	%>
	<form action="/InteracoesMedicamentosas/Reacoes" method="post">
		<table id="tabela">
			<tr>
				<td>
					Codigo:
				</td>
				<td>
					<input type="text" name="id" value="<% if(reacao != null){ out.print(reacao.getId()); } %>" />
				</td>
			</tr>
			
			<tr>
				<td>
					Nome:
				</td>
				<td>
					<input type="text" name="nome" value="<% if(reacao != null){ out.print(reacao.getNome()); } %>" />
				</td>
			</tr>
			<tr>
				<td>
			<input type="submit" value="Salvar" />
				</td>
			</tr>
		</table>
		
	</form>
	</td>
			</tr>
	</table>
</body>
</html>