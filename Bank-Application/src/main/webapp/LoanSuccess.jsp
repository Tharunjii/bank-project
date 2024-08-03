<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loan Success Page</title>
<link href="Loansuccess.css" rel="stylesheet"/>
</head>
<body>
	<%
		session = request.getSession();
		out.println("<h2>"+"Dear,"+"<b>"+session.getAttribute("name")+"</b>"+" thank you for showing interest on the loans from our ABC Bank."+"</h2>");
		out.println("<h2>"+"Our executive will contact you soon on your email address mentioned below."+"</h2>");
		out.println("<h1>"+"<b>"+session.getAttribute("email")+"</b>"+"</h1>");
	%>
</body>
</html>