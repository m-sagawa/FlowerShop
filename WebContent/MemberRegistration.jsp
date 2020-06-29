<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body class="login">
	<img alt="FlowerShop" src="flower/FlowerShop.png" width=200 height=50>
	<div class="login">
	<%
	String message = (String)request.getAttribute("message");
	if(message == null){
		message = "";
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

	<div class="message">登録する会員情報を入力してください</div><br>
	<form action="member-registration-servlet" method="post">
		ID<input type="text" name="user_id"><br>
		password<input type="password" name="user_password"><br>
		確認用password<input type="password" name="u_password"><br>
		<button class="button" name="conf" value="n">登録</button>
	</form>
		<a href="Login.jsp"><input class="button" type="submit" value="キャンセル"></a>
	</div>
</body>
</html>