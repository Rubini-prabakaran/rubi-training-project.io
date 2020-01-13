<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie list admin</title>
<meta name="viewport" content="width-advice-width">
<link rel="stylesheet" href="styles/movie.css">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<a href="ShowMovieListAdmin">Movies</a> <img
			src="images/movie cruiser image.png">
	</div>
	<h1>Movies</h1>
	<div id="paradiv"></div>
	<table>
		<tr>
			<th>Title</th>
			<th>Box Office</th>
			<th>Active</th>
			<th>Date of Launch</th>
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
				<td><c:choose>
						<c:when test="${movies.active eq 'true'}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><fmt:formatDate pattern='dd/MM/yyyy'
						value='${movies.dateOfLaunch}' /></td>
				<td>${movies.genre}</td>
				<td><c:choose>
						<c:when test="${movies.hasTeaser eq 'true'}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><a href="ShowEditMovieList?id=${movies.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>
