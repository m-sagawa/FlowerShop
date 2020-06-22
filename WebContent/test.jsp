<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テスト用画面</title>
</head>
<body>
	<%
	String message = (String)request.getAttribute("message");
	%>
	<%=message %>
</body>
</html>