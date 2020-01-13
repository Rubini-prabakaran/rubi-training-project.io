<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Menu Item list admin</title>
<meta name="viewport" content="width-advice-width">
<link rel="stylesheet" href="styles/style.css">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<a href="ShowMenuItemListAdmin">Menu</a> <img
			src="images/truyum-logo-light.png">
	</div>
	<h1>Menu Items</h1>
	<div id="paradiv"></div>
	<table>
		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Category</th>
			<th>Free Delivery</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${menuItem}" var="menuItem">
			<tr>
				<td>${menuItem.name}</td>
				<td><fmt:setLocale value="en_IN" /> <fmt:formatNumber
						value="${menuItem.price}" type="currency"
						pattern="#,##,##,##,###.00" /></td>
				<td><c:choose>
						<c:when test="${menuItem.active eq 'true'}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><fmt:formatDate pattern='dd/MM/yyyy'
						value='${menuItem.dateOfLaunch}' /></td>
				<td>${menuItem.category}</td>
				<td><c:choose>
						<c:when test="${menuItem.freeDelivery eq 'true'}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><a href="ShowEditMenuItem?id=${menuItem.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>
