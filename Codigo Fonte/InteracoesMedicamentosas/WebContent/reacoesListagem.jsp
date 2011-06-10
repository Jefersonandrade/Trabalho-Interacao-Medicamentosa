<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="domainModel.Reacao" %>
<%@page import="java.util.List, java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Listagem de Reacoes</title>
</head>
<body>
<%
	List reacoes = (List) request.getAttribute("reacao");
	if(reacoes != null){
		%>
		<table>
		<tr><td>ID</td><td>Nome</td></tr>
		<%
		Iterator it = reacoes.iterator();
		while(it.hasNext()){
			Reacao r= (Reacao)it.next();
			%>
				<tr>
					<td><%=r.getId() %></td>
					<td><%=r.getNome() %></td>			
					<td><a href="/interacoesmedicamentosas/Reacoes?edit=<%=r.getId() %>">Editar</a></td>
					<td><a href="/interacoesmedicamentosas/Reacoes?del=<%=r.getId() %>">Apagar</a></td>
					
				</tr>
			<%
		}
		%>
		</table>
		<%
	}
%>
<a href="/interacoesmedicamentosas/Reacoes?edit=new">Criar Novo Reacao</a>

</body>
</html>