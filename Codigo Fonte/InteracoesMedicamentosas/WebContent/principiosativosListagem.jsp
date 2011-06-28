<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="domainModel.PrincipioAtivo" %>
<%@page import="java.util.List, java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link  rel="StyleSheet" type="text/css" href="estilo.css" media="screen"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Listagem de Principios Ativos</title>
</head>
<body>
<table border="2px solid gray">
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
<%
	List principiosativos = (List) request.getAttribute("principiosativos");
	if(principiosativos != null){
		%>
	<tr>
		<td align="center">
<h3> Cadastrar Principio Ativo </h3>
</td>
</tr>
		<tr>
		<td>
		<table id="tabela" border="2px solid gray">

<tr>
		<td>ID</td><td>Nome</td></tr>
		<%
		Iterator it = principiosativos.iterator();
		while(it.hasNext()){
			PrincipioAtivo pa= (PrincipioAtivo)it.next();
			%>
				<tr>
					<td><%=pa.getId() %></td>
					<td><%=pa.getNome() %></td>			
					<td><a href="/InteracoesMedicamentosas/PrincipiosAtivos?edit=<%=pa.getId() %>">Editar</a></td>
					<td><a href="/InteracoesMedicamentosas/PrincipiosAtivos?del=<%=pa.getId() %>">Apagar</a></td>
					
				</tr>
			<%
		}
		%>
		</table>
		<%
	}
%>
			
		</td>
	</tr>
	<tr>
<td>
<a href="/InteracoesMedicamentosas/PrincipiosAtivos?edit=new">Criar Novo Principio Ativo</a>
<a href="http://localhost:8080/InteracoesMedicamentosas/index.jsp"> Voltar </a>
</td>
</tr>
</table>
</body>
</html>