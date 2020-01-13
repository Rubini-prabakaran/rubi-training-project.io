package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.movie.Dao.FavouriteDao;
import com.cognizant.movie.Dao.FavouriteDaoSqlImpl;
import com.cognizant.movie.Dao.MovieListDaoSqlImpl;
import com.cognizant.movie.Dao.MoviesDao;
import com.cognizant.movie.model.Movies;

/**
 * Servlet implementation class AddToFavouriteServlet
 */
@WebServlet("/AddToFavourite")
public class AddToFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavourite() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long userId = 1l;
		Long movieId = Long.parseLong(request.getParameter("id"));
		FavouriteDao favouriteDao = new FavouriteDaoSqlImpl();
		favouriteDao.addFavouriteMovies(userId, movieId);
		MoviesDao moviesDao = new MovieListDaoSqlImpl();
		List<Movies> movieList = moviesDao.getMovieListCustomer();
		request.setAttribute("movies", movieList);
		request.setAttribute("addFavouriteStatus", true);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
