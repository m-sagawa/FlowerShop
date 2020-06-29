<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
	<div class="adminHeader">
	<jsp:include page="AdminHeader.jsp">
		<jsp:param value="header" name="deader" />
	</jsp:include>
	</div>

	<div class="main">
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

	<div class="message">登録する内容を入力してください<br></div>
	<form action="goods-registration-servlet" method="post">
		商品名<input type="text" name="goodsName"><br>
		価格<input type="text" name="goodsPrice"><br>
		在庫<input type="text" name="goodsNumber"><br>
		写真<input type="text" name="goodsImg"><br>
		説明文<textarea name="goodsInfo" rows="6" cols="50">300文字以内で入力してください</textarea><br>
		花言葉<input type="text" name="goodsLang"><br>
		<button name="conf" value="n">登録</button>
	</form>
	<form action="sort-serch-servlet" method="post">
	<button name="forward" value="AdminHome.jsp">キャンセル</button>
	</form>
	</div>
</body>
</html>