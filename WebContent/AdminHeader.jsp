<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="javax.servlet.http.HttpSession"%>

<% String header = request.getParameter("header"); %>

<div style="header:<%=header %>">
	<div class="inline-block">
	<img alt="FlowerShop" src="flower/FlowerShop.png" width=200 height=50>

	<%
	String userID = (String)session.getAttribute("userID");
	%>

	<%=userID %>さん<br>
	</div>

	<div class="inline-block">
	<form action="sort-serch-servlet" method="post">
	<button name="forward" value="AdminHome.jsp">Home</button>
	</form>
	</div>

	<div class="inline-block">
	<a href="GoodsRegistration.jsp"><input type="button" value="新規登録"></a>
	</div>

	<div class="inline-block">
	<form action="sort-serch-servlet" method="post">
	<button name="forward" value="GoodsDelete.jsp">削除</button>
	</form>
	</div>

	<div class="inline-block">
	<form action="logout-servlet" method="post">
	<input type="submit" value="Logout">
	</form>
	</div>

	<img alt="cloverLINE" src="flower/cloverLINE.png" width=100% height=30>
</div>