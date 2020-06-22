<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.GoodsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品登録確認画面</title>
</head>
<body>
	<jsp:include page="AdminHeader.jsp">
		<jsp:param value="header" name="deader" />
	</jsp:include>

	以下の内容で登録してもよろしいでしょうか<br>
	<%
	GoodsBean goodsBean = (GoodsBean)request.getAttribute("goodsBean");
	String goodsName = goodsBean.getGoodsName();
	int goodsPrice = goodsBean.getGoodsPrice();
	String goodsImg = goodsBean.getGoodsImg();
	%>
	<form action="goods-registration-servlet" method="post">
		商品名<input type="text" name="goodsName" value="<%=goodsName %>" readonly><br>
		価格<input type="text" name="goodsPrice" value="<%=goodsPrice %>" readonly><br>
		写真<input type="text" name="goodsImg" value="<%=goodsImg %>" readonly><br>
		<button name="conf" value="y">登録</button>
	</form>
	<form action="sort-serch-servlet" method="post">
	<button name="forward" value="AdminHome.jsp">キャンセル</button>
	</form>
</body>
</html>