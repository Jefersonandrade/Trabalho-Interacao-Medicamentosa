<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="domainModel.PrincipioAtivo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Editar Principio Ativo</title>
</head>
<body>
	<%
	PrincipioAtivo principioAtivo = (PrincipioAtivo) request.getAttribute("principioAtivo");
	%>
	<form action="/interacoesmedicamentosas/PrincipiosAtivos" method="post">
		<table>
			<tr>
				<td>
					Codigo:
				</td>
				<td>
					<input type="text" name="cod" value="<% if(principioAtivo != null){ out.print(principioAtivo.getId()); } %>" />
				</td>
			</tr>
			
			<tr>
				<td>
					Nome:
				</td>
				<td>
					<input type="text" name="nome" value="<% if(principioAtivo != null){ out.print(principioAtivo.getNome()); } %>" />
				</td>
			</tr>
		</table>
		<input type="submit" value="Salvar" />
	</form>

</body>
</html>