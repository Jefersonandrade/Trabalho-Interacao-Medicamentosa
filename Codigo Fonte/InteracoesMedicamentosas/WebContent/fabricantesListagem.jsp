<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="domainModel.Fabricante" %>
<%@page import="java.util.List, java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link  rel="StyleSheet" type="text/css" href="estilo.css" media="screen"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Listagem de Fabricantes</title>
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
	List fabricantes = (List) request.getAttribute("fabricantes");
	if(fabricantes != null){
		%>
	<tr>
		<td align="center">
<h3> Cadastrar Fabricante </h3>
</td>
</tr>
		<tr>
		<td>
		<table id="tabela" border="2px solid gray">

<tr>
<td>ID</td><td>Nome</td></tr>
		<%
		Iterator it = fabricantes.iterator();
		while(it.hasNext()){
			Fabricante f = (Fabricante)it.next();
			%>
				<tr>
					<td><%=f.getId() %></td>
					<td><%=f.getNome() %></td>			
					<td><a href="/InteracoesMedicamentosas/Fabricantes?edit=<%=f.getId() %>">Editar</a></td>
					<td><a href="/InteracoesMedicamentosas/Fabricantes?del=<%=f.getId() %>">Apagar</a></td>
					
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
<a href="/InteracoesMedicamentosas/Fabricantes?edit=new">Criar Novo Fabricante</a>

<a href="http://localhost:8080/InteracoesMedicamentosas/index.jsp"> Voltar </a>
</td>
</tr>
</table>
</body>
</html>