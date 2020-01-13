<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/movie.css">
<title>Insert title here</title>
<script src="js/cruiser.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movie cruiser image.png"> <a
			href="ShowMovieListAdmin">Movies</a>
	</div>
	<div class="content">
		<h1>Edit Movie</h1>
		<div class="body-content-color">
			<form action="EditMovieList"
				onsubmit="return validateMovieListForm()" name="MovieListForm"
				method="post">
				<div class="form-field-spacing">
					<label for="title"><b>Title</b></label><br> <input type="text"
						class="text-box" name="title" value="${movies.title}" id="title"
						size="138">
				</div>
				<div>
					<div class="form-field-spacing">
						<label for="gross"><b>Gross($)</b></label><br> <input
							type="text" class="text-box" value="${movies.gross}" name="gross"
							id="gross">
					</div>
					<div class="form-field-spacing">
						<label for="instock"><b>Active</b></label>
						<div>
							<c:if test="${movies.active }">
								<input type="radio" name="active" value="Yes" checked>Yes
                    <input type="radio" name="active" value="No">No
                    </c:if>
							<c:if test="${!movies.active }">
								<input type="radio" name="active" value="Yes" checked>Yes
                    <input type="radio" name="active" value="No" checked>No
                    </c:if>
						</div>
					</div>
					<div class="form-field-spacing">
						<label for="dateOfLaunch"><b>Date of Launch</b></label>
						<div>

							<input type="text" class="text-box" name="dateOfLaunch"
								value="<fmt:formatDate type="date" pattern="dd/MM/yyyy"
                                         value="${movies.dateOfLaunch}" />">
						</div>
					</div>
					<div class="form-field-spacing">
						<label for="genre"><b>Genre</b></label>
						<div>
							<select name="genre" class="dropdown" id="genre">
								<option value="${movies.genre }">${movies.genre }</option>
								<option value="action">Action</option>
								<option value="romantic">Romantic</option>
								<option value="superhero">Super hero</option>
								<option value="science fiction">Science Fiction</option>
							</select>
						</div>
					</div>
				</div>
				<div>
					<div class="form-field-spacing">
						<c:if test="${movies.hasTeaser}">
							<input type="checkbox" name="hasTeaser" checked>
						</c:if>
						<c:if test="${!movies.hasTeaser }">
							<input type="checkbox" name="hasTeaser">
						</c:if>
						<label for="hasTeaser"><b>Has Teaser</b></label>
					</div>
					<div>
						<input type="hidden" name="id" value="${movies.id}">
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


