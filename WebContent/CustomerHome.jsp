<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Dao" import="java.util.List"
	import="model.GoodsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客ホーム画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/CustomerStyle.css">
</head>
<body>
	<div class="header">
	<jsp:include page="CustomerHeader.jsp">
		<jsp:param value="header" name="deader" />
	</jsp:include>
	</div>

	<div class="main">
	<form action="sort-serch-servlet" method="post">
		検索 <input type="text" name="sarch">
		並び替え <select name="sort">
			<option value=""></option>
			<option value="goods_name">商品名</option>
			<option value="goods_price">価格</option>
		</select>
		<button name="forward" value="CustomerHome.jsp">表示</button>
	</form>

	<%
	List<GoodsBean> goodsList = (List<GoodsBean>)request.getAttribute("goodsList");
	for(GoodsBean gb : goodsList){
		String goodsName = gb.getGoodsName();
		int goodsPrice = gb.getGoodsPrice();
		String goodsImg = gb.getGoodsImg();
	%>
		<div class="inline-block">
		<img alt="<%=goodsName %>" src="flower/<%=goodsImg %>" width=200 height=200><br>
		【<%=goodsName %>】　<%=goodsPrice %>円<br>
		<form action="cart-servlet" method="post">
		<select name="goodsNumber">
			<%
			for(int i = 0; i <= 10; i++){
			%>
			<option value="<%=i %>"><%=i %></option>
			<%
			}
			%>
		</select>
		<button name="goodsName" value="<%=goodsName %>">カートに入れる</button><br>
		</form>
		</div>
	<%
	}
	%>
	</div>
</body>
</html>