<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Dao" import="java.util.List"
	import="model.GoodsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品削除確認画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminStyle.css">
</head>
<body>
	<div class="header">
	<jsp:include page="AdminHeader.jsp">
		<jsp:param value="header" name="deader" />
	</jsp:include>
	</div>

	<div class="main">
	<div class="message">以下の内容を削除してよろしいでしょうか<br></div>
	<%
	List<GoodsBean> goodsList = (List<GoodsBean>)request.getAttribute("goodsList");
	for(GoodsBean gb : goodsList){
		String goodsName = gb.getGoodsName();
		int goodsPrice = gb.getGoodsPrice();
		String goodsImg = gb.getGoodsImg();
	%>
		<div class="inline-block">
		<img alt="<%=goodsName %>" src="flower/<%=goodsImg %>" width=200 height=200><br>
		【<%=goodsName %>】　<%=goodsPrice %>円
		<form action="goods-delete-servlet" method="post">
		<input type="checkbox" name="goodsName" value="<%=goodsName %>" checked="checked"><br>
		</form>
		</div>
	<%
	}
	%>
	<form action="delete-servlet" method="post">
	<button name="conf" value="y">削除</button>
	</form>
	</div>
</body>
</html>