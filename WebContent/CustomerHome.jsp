<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Dao" import="java.util.List"
	import="model.GoodsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客ホーム画面</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<jsp:include page="CustomerHeader.jsp">
		<jsp:param value="header" name="deader" />
	</jsp:include>

	<form action="sort-serch-servlet" method="post">
		検索 <input type="text" name="sarch"> 並び替え <select name="sort">
			<option value=""></option>
			<option value="goods_name">商品名</option>
			<option value="goods_price">価格</option>
		</select> <input type="submit" value="表示">
	</form>

	<%
	List<GoodsBean> goodsList = (List<GoodsBean>)request.getAttribute("goodsList");
	for(GoodsBean gb : goodsList){
		String goodsName = gb.getGoodsName();
		int goodsPrice = gb.getGoodsPrice();
		String goodsImg = gb.getGoodsImg();
	%>
		<img alt="<%=goodsName %>" src="<%=goodsImg %>"><br>
		【<%=goodsName %>】\<%=goodsPrice %><br>
	<%
	}
	%>
</body>
</html>