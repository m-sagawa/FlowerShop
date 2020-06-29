<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body class="login">
	<img alt="FlowerShop" src="flower/FlowerShop.png" width=200 height=50>
	<%
	String message = (String)request.getAttribute("message");
	if(message == null){
		message = "　";
	}
	%>
	<div class="message"><%=message %></div>
	<%
	String error = (String)request.getAttribute("error");
	if(error == null){
		error = "";
	}
	%>
	<div class="error"><%=error %></div>

	<form action="login-servlet" method="post">
		ID<input type="text" name="userID"><br>
		password<input type="password" name="userPASS"><br>
		<input class="button" type="submit" value="Login">
	</form>

	<br><a href="MemberRegistration.jsp"><input class="button" type="submit" value="会員登録はこちら"></a>
</body>
</html>