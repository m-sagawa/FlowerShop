<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<img alt="FlowerShop" src="FlowerShop.png" width=200 height=50>
	<%
	String message = (String)request.getAttribute("message");
	if(message == null){
		message = "　";
	}
	%>
	<%=message %>
	<form action="login-servlet" method="post">
		ID<input type="text" name="userID"><br>
		password<input type="password" name="userPASS"><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>