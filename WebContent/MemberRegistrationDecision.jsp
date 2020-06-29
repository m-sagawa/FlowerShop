<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録確認画面</title>
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

	<div class="message">以下の内容で登録してもよろしいでしょうか<br></div>
	<%
	String user_id = (String)request.getAttribute("user_id");
	String user_password = (String)request.getAttribute("user_password");
	%>

	<form action="member-registration-servlet" method="post">
		ID<input type="text" name="user_id" value="<%=user_id %>" readonly><br>
		password<input type="password" name="user_password" value="<%=user_password%>" readonly><br>
		<button class="button" name="conf" value="y">登録</button>
	</form>
		<a href="Login.jsp"><input class="button" type="submit" value="キャンセル"></a>
	</div>
</body>
</html>