<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Dao" import="java.util.List"
	import="model.GoodsBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品削除確認画面</title>
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

	<div class="message">以下の内容を削除してよろしいでしょうか<br></div>
	<%
	List<GoodsBean> deleteList = (List<GoodsBean>)request.getAttribute("deleteList");
	request.setAttribute("deleteList", deleteList);
	for(GoodsBean dl : deleteList){
		String goodsName = dl.getGoodsName();
		int goodsPrice = dl.getGoodsPrice();
		String goodsImg = dl.getGoodsImg();
		int goodsNumber = dl.getGoodsNumber();
	%>
		<form action="goods-delete-servlet" method="post">
		<div class="inline-block">
		<img alt="<%=goodsName %>" src="flower/<%=goodsImg %>" width=200 height=200><br>
		【<%=goodsName %>】　<%=goodsPrice %>円　在庫：<%=goodsNumber %><br>
		削除：<input type="checkbox" name="goodsName" value="<%=goodsName %>" checked="checked">
		</div>
	<%
	}
	%>
	<button name="conf" value="y">削除</button>
		</form>
	<form action="sort-sarch-servlet" method="post">
	<button name="foward" value="AdminHome.jsp">キャンセル</button>
	</form>
	</div>
</body>
</html>