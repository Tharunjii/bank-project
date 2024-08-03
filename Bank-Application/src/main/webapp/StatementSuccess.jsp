<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statement Success Page</title>
<link href="StatementSuccess.css" rel="stylesheet"/>
</head>
<body>
	<%
		out.println("<h1>"+"Your bank statement:"+"</h1>");
		session = request.getSession();
		out.println("<h3>"+session.getAttribute("sal")+"</h3>");
		
		out.println("<h3>"+session.getAttribute("ral")+"</h3>");
		
		out.println("<h3>"+session.getAttribute("al")+"</h3>");
	%>
</body>
</html>