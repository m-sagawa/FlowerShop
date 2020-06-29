<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.GoodsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>花の詳細</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/Style.css">
</head>
<body>
	<div class="customerHeader">
	<jsp:include page="CustomerHeader.jsp">
		<jsp:param value="header" name="deader" />
	</jsp:include>
	</div>
	<%
	GoodsBean gb = (GoodsBean)request.getAttribute("goodsBean");
	String goodsName = gb.getGoodsName();
	int goodsPrice = gb.getGoodsPrice();
	String goodsImg = gb.getGoodsImg();
	int goodsNumber = gb.getGoodsNumber();
	String goodsInfo = gb.getGoodsInfo();
	String goodsLang = gb.getGoodsLang();
	%>

	<div class="main">
	<h2><%=goodsName %></h2>
	<div class="inline-block">
	<img alt="<%=goodsName %>" src="flower/<%=goodsImg %>" width=300 height=300><br>
	</div>
	<div class="inline-block">
	<%=goodsInfo %><br>
	花言葉：<%=goodsLang %><br>
	</div>
	<br>価格：<%=goodsPrice %>円
	<%
	if(goodsNumber == 0){
	%>
		<div class="error">在庫切れ中です</div><br>
	<%
	}else{
	%>
		<form action="cart-servlet" method="post">
		<select name="goodsBuyNumber">
			<%
			for(int i = 0; i <= goodsNumber; i++){
			%>
			<option value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>
		<button class="inline-block" name="goodsName" value="<%=goodsName %>">カートに入れる</button><br>
		</form>
		<form action="sort-serch-servlet" method="post">
		<button class="inline-block" name="forward" value="CustomerHome.jsp">Home</button>
		</form>
	<%
	}
	%>
	</div>
</body>
</html>