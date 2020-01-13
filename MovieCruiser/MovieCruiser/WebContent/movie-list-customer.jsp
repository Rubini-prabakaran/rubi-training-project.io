<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/movie.css">
<title>Movie list for customer</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movie cruiser image.png"> <a
			href="ShowFavourite">Favorites</a> <a href="ShowMovieListCustomer">Movies</a>
	</div>
	<c:if test="${addFavouriteStatus}">
		<div class="success-message">Movie added to Favourites
			successfully</div>
	</c:if>
	<h1>Movies</h1>
	<div id="paradiv"></div>
	<table>
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${movies}" var="movies">
			<tr>
				<td>${movies.title}</td>
				<td>$<fmt:setLocale value="en_IN" /> <fmt:formatNumber
						value="${movies.gross}" type="currency"
						pattern="#,##,##,##,###.00" /></td>
				<td>${movies.genre}</td>
				<td><c:choose>
						<c:when test="${movies.hasTeaser eq 'true'}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><a href="AddToFavourite?id=${movies.id}">Add to
						Favorites </a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>