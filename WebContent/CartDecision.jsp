<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.CartBean" import="model.GoodsBean" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート画面</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<jsp:include page="CustomerHeader.jsp">
		<jsp:param value="header" name="deader" />
	</jsp:include>

	以下の内容で購入確定してもよろしいですか<br>
	<form action="cart-servlet" method="post">
	<%
	int total = 0;
	List<CartBean> cartList = (List<CartBean>)session.getAttribute("cartList");
	int index = 0;
	for(CartBean cb : cartList){
		GoodsBean goodsBean = cb.getGoodsBean();
		int goodsNumber = cb.getGoodsNumber();

		String goodsName = goodsBean.getGoodsName();
		int goodsPrice = goodsBean.getGoodsPrice();
		String goodsImg = goodsBean.getGoodsImg();
		int subtotal = goodsPrice * goodsNumber;
	%>

		<img alt="<%=goodsName %>" src="flower/<%=goodsImg %>" width=200 height=200><br>
		【<%=goodsName %>】<br>
		単価：<%=goodsPrice %>円<br>
		個数：<%=goodsNumber %>個<br>
		小計：<%=subtotal %>円<br>
	<%
		total += subtotal;
		index += 1;
	}
	%>

	合計：<%=total %>円
	<button name="conf" value="y">購入確定</button><br>
	</form>
</body>
</html>