<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String header = request.getParameter("header"); %>

<div style="header:<%=header %>">
	<img alt="FlowerShop" src="FlowerShop.png" width=200 height=50>

	<%
	String userID = (String)session.getAttribute("userID");
	%>

	<%=userID %>さん<br>

	<form action="sort-serch-servlet" method="post">
	<button name="forward" value="CustomerHome.jsp">Home</button>
	</form>

	<a href="Cart.jsp"><input type="button" value="MyCart"></a>

	<form action="logout-servlet" method="post">
	<input type="submit" value="Logout">
	</form>
</div>
