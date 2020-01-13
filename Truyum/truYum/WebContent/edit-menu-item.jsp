<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<title>Insert title here</title>
<script src="js\editmenu2.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>
	<div class="content">
		<h1>Edit menu Item</h1>
		<div class="body-content-color">
			<form action="EditMenuItem"
				onsubmit="return validateMenuItemForm()" name="MenuItemForm"
				method="post">
				<div class="form-field-spacing">
					<label for="Name"><b>Name</b></label><br> <input type="text"
						class="text-box" name="name" value="${menuItem.name}" id="title"
						size="138">
				</div>
				<div>
					<div class="form-field-spacing">
						<label for="price"><b>price(Rs)</b></label><br> <input
							type="text" class="text-box" value="${menuItem.price}"
							name="price" id="price">
					</div>
					<div class="form-field-spacing">
						<label for="active"><b>Active</b></label>
						<div>
							<c:if test="${menuItem.active}">
								<input type="radio" name="active" value="yes" checked>Yes
								<input type="radio" name="active" value="no">No
						</c:if>
							<c:if test="${!menuItem.active}">
								<input type="radio" name="active" value="yes" checked>Yes
								<input type="radio" name="active" value="no" checked>No
						</c:if>
						</div>
					</div>
					<div class="form-field-spacing">
						<label for="dateOfLaunch"><b>Date of Launch</b></label>
						<div>
							<input type="text" class="text-box" name="dateOfLaunch"
								value="<fmt:formatDate type="date" pattern="dd/MM/yyyy"
                                         value="${menuItem.dateOfLaunch}" />">
						</div>
					</div>
					<div class="form-field-spacing">
						<label for="category"><b>Category</b></label>
						<div>
							<select name="category" class="dropdown" id="category">
								<option value="${menuItem.category }">${menuItem.category }</option>
								<option value="starters">Starters</option>
								<option value="maincourse">Main Course</option>
								<option value="dessert">Dessert</option>
								<option value="drinks">Drinks</option>
							</select>
						</div>
					</div>
				</div>
				<div>
					<div class="form-field-spacing">
						<c:if test="${menuItem.freeDelivery }">
							<input type="checkbox" name="freedelivery" checked>
						</c:if>
						<c:if test="${!menuItem.freeDelivery }">
							<input type="checkbox" name="freeDelivery">
						</c:if>
						<label for="freedelivery">Free Delivery</label>
					</div>
					<div>
						<input type="hidden" name="id" value="${menuItem.id}">
					</div>
				</div>
				<br></br>
				<div>
					<input type="submit" class="button success-button" value="Save">
				</div>
			</form>
		</div>
	</div>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>