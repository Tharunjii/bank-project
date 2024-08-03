<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance view page</title>
<link href="Balanceview.css" rel="stylesheet"/>
</head>
<body>
	
<%
	session = request.getSession();
	out.println("<h1>"+"Your balance is:"+"</h1>");
	out.println("<h1>"+session.getAttribute("bal")+"</h1>");
%>
</body>
</html>