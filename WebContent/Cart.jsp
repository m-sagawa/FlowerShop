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

	<form action="cart-servlet" method="post">
	<%
	int total = 0;
	List<CartBean> cartList = (List<CartBean>)session.getAttribute("cartList");
	int in = 0;
	for(CartBean cb : cartList){
		GoodsBean goodsBean = cb.getGoodsBean();
		int goodsNumber = cb.getGoodsNumber();

		String goodsName = goodsBean.getGoodsName();
		int goodsPrice = goodsBean.getGoodsPrice();
		String goodsImg = goodsBean.getGoodsImg();
		int subtotal = goodsPrice * goodsNumber;
		String index = String.valueOf(in);
	%>

		<img alt="<%=goodsName %>" src="flower/<%=goodsImg %>" width=200 height=200><br>
		【<%=goodsName %>】<br>
		単価：<%=goodsPrice %>円<br>
		<%--
		個数：<select name="<%=index %>">
			<option value="<%=goodsNumber%>"><%=goodsNumber %></option>
		<%
		for(int i = 0; i <= 10; i++){
		%>
			<option value="<%=i %>"><%=i %></option>
		<%
		}
		%>
		</select>個<br>
		--%>
		個数：<%=goodsNumber %>個<br>
		小計：<%=subtotal %>円<br>

		削除する<input type="checkbox" name="deleteCart" value="<%=index%>"><br>
	<%
		total += subtotal;
		in += 1;
	}
	session.setAttribute("cartList", cartList);
	%>
	合計：<%=total %>円

	<button name="conf" value="h">カートから削除</button>チェックしたものをカートから削除します<br>
	<button name="conf" value="n">購入</button><br>
	</form>
</body>
</html>