<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	<button class="button" name="forward" value="CustomerHome.jsp">Home</button>
	</form>
	</div>

	<div class="inline-block">
	<a href="Cart.jsp"><input class="button" type="button" value="MyCart"></a>
	</div>

	<div class="inline-block">
	<form action="logout-servlet" method="post">
	<input class="button" type="submit" value="Logout">
	</form>
	</div>

	<img alt="flowerLINE" src="flower/flowerLINE.png" width=100% height=30>
</div>
