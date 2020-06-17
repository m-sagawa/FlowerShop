<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String header = request.getParameter("header"); %>

<div style="header:<%=header %>">
	<form action="loogout-servlet" method="post">
	<img alt="FlowerShop" src="FlowerShop.png">
	<a href="CustomerHome.jsp"><input type="button" value="Home"></a>
	<a href="Cart.jsp"><input type="button" value="MyCart"></a>
	<input type="submit" value="Logout">
	</form>
</div>
