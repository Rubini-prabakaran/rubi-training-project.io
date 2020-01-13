package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.movie.Dao.MovieListDaoSqlImpl;
import com.cognizant.movie.Dao.MoviesDao;
import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;

/**
 * Servlet implementation class EditMovieListServlet
 */
@WebServlet("/EditMovieList")
public class EditMovieList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieList() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String title = request.getParameter("title");
		long gross = Long.parseLong(request.getParameter("gross"));
		boolean active = request.getParameter("active").equals("Yes");
		// SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Date dateOfLaunch;
		dateOfLaunch = new DateUtil().convertToDate(request.getParameter("dateOfLaunch"));
		String genre = request.getParameter("genre");
		boolean hasTeaser = request.getParameter("hasTeaser") != null;
		Movies movie = new Movies(id, title, gross, active, dateOfLaunch, genre, hasTeaser);
		MoviesDao moviesDao = new MovieListDaoSqlImpl();
		moviesDao.modifyMovies(movie);
		request.getRequestDispatcher("edit-movie-list-status.jsp").forward(request, response);
	}
}
