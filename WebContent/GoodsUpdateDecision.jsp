<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.GoodsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品変更確認画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminStyle.css">
</head>
<body>
	<div class="header">
	<jsp:include page="AdminHeader.jsp">
		<jsp:param value="header" name="deader" />
	</jsp:include>
	</div>

	<div class="main">
	<div class="message">以下の内容で変更してもよろしいでしょうか<br></div>
	<%
	GoodsBean goodsBean = (GoodsBean)request.getAttribute("goodsBean");
	String goodsName = goodsBean.getGoodsName();
	int goodsPrice = goodsBean.getGoodsPrice();
	String goodsImg = goodsBean.getGoodsImg();
	%>
	<form action="goods-update-servlet" method="post">
		商品名<input type="text" name="goodsName" value="<%=goodsName %>" readonly><br>
		価格<input type="text" name="goodsPrice" value="<%=goodsPrice %>" readonly><br>
		写真<input type="text" name="goodsImg" value="<%=goodsImg %>" readonly><br>
		<button name="conf" value="y">変更</button>
	</form>
	<form action="sort-serch-servlet" method="post">
	<button name="forward" value="AdminHome.jsp">キャンセル</button>
	</form>
	</div>
</body>
</html>