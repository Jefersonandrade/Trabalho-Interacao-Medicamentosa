<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="domainModel.PrincipioAtivo" %>
<%@page import="java.util.List, java.util.Iterator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Listagem de Reacoes</title>
</head>
<body>
<%
	List principiosativos = (List) request.getAttribute("principioAtivo");
	if(principiosativos != null){
		%>
		<table>
		<tr><td>ID</td><td>Nome</td></tr>
		<%
		Iterator it = principiosativos.iterator();
		while(it.hasNext()){
			PrincipioAtivo c= (PrincipioAtivo)it.next();
			%>
				<tr>
					<td><%=c.getId() %></td>
					<td><%=c.getNome() %></td>			
					<td><a href="/interacoesmedicamentosas/PrincipiosAtivos?edit=<%=c.getId() %>">Editar</a></td>
					<td><a href="/interacoesmedicamentosas/PrincipiosAtivos?del=<%=c.getId() %>">Apagar</a></td>
					
				</tr>
			<%
		}
		%>
		</table>
		<%
	}
%>
<a href="/interacoesmedicamentosas/PrincipiosAtivos?edit=new">Criar Novo Principio Ativo</a>

</body>
</html>