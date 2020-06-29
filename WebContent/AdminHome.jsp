<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Dao" import="java.util.List"
	import="model.GoodsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ホーム画面</title>
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
	String message = (String)session.getAttribute("message");
	if(message == null){
		message = "";
	}
	%>
	<div class="message"><%=message %></div>
	<%
	session.removeAttribute("message");
	%>
	<%
	String error = (String)session.getAttribute("error");
	if(error == null){
		error = "";
	}
	%>
	<div class="error"><%=error %></div>
	<%
	session.removeAttribute("error");
	%>

	<form action="sort-serch-servlet" method="post">
		検索 <input type="text" name="sarch"> 並び替え <select name="sort">
			<option value=""></option>
			<option value="goods_name">商品名</option>
			<option value="goods_price">価格</option>
		</select>
		<button name="forward" value="AdminHome.jsp">表示</button>
	</form>

	<%
	List<GoodsBean> goodsList = (List<GoodsBean>)request.getAttribute("goodsList");
	for(GoodsBean gb : goodsList){
		String goodsName = gb.getGoodsName();
		int goodsPrice = gb.getGoodsPrice();
		String goodsImg = gb.getGoodsImg();
		int goodsNumber = gb.getGoodsNumber();
	%>
		<div class="inline-block">
		<img alt="<%=goodsName %>" src="flower/<%=goodsImg %>" width=200 height=200><br>
		【<%=goodsName %>】　<%=goodsPrice %>円　在庫：<%=goodsNumber %><br>
		<form action="goods-update-servlet" method="post">
		<button name="goodsName" value="<%=goodsName %>">変更</button><br>
		</form>
		</div>
	<%
	}
	%>
	</div>
</body>
</html>