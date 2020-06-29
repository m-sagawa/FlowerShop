<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Dao" import="java.util.List"
	import="model.GoodsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品削除画面</title>
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

	<div class="message">削除する項目を選んでください<br></div>
	<form action="sort-serch-servlet" method="post">
		検索 <input type="text" name="sarch">
		並び替え <select name="sort">
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
		int goodsNumber = gb.getGoodsNumber();
	%>
		<form action="goods-delete-servlet" method="post">
		<div class="inline-block">
		<img alt="<%=goodsName %>" src="flower/<%=goodsImg %>" width=200 height=200><br>
		【<%=goodsName %>】　<%=goodsPrice %>円　在庫：<%=goodsNumber %><br>
		削除：<input type="checkbox" name="goodsName" value="<%=goodsName %>">
		</div>
	<%
	}
	%>
	<br><button name="conf" value="n">削除</button>
		</form>
	<form action="sort-serch-servlet" method="post">
	<button name="foward" value="AdminHome.jsp">キャンセル</button>
	</form>
	</div>
</body>
</html>