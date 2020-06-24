<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminStyle.css">
</head>
<body>
	<div class="header">
	<jsp:include page="AdminHeader.jsp">
		<jsp:param value="header" name="deader" />
	</jsp:include>
	</div>

	<div class="main">
	<div class="message">登録する内容を入力してください<br></div>
	<form action="goods-registration-servlet" method="post">
		商品名<input type="text" name="goodsName"><br>
		価格<input type="text" name="goodsPrice"><br>
		写真<input type="text" name="goodsImg"><br>
		<button name="conf" value="n">登録</button>
	</form>
	<form action="sort-serch-servlet" method="post">
	<button name="forward" value="AdminHome.jsp">キャンセル</button>
	</form>
	</div>
</body>
</html>