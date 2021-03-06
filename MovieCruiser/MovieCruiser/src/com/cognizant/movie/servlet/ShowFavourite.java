package com.cognizant.movie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cognizant.movie.Dao.FavouriteDao;
import com.cognizant.movie.Dao.FavouriteDaoSqlImpl;
import com.cognizant.movie.Dao.FavouriteEmptyException;
import com.cognizant.movie.model.Favourite;

/**
 * Servlet implementation class ShowFavouriteServlet
 */
@WebServlet("/ShowFavourite")
public class ShowFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFavourite() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long userId = 1l;
		FavouriteDao moviesDao = new FavouriteDaoSqlImpl();
		try {
			Favourite favourite = moviesDao.getAllFavouriteMovies(userId);
			request.setAttribute("favourite", favourite);
			// request.setAttribute("message",true);
			request.getRequestDispatcher("favourite.jsp").forward(request, response);
		} catch (FavouriteEmptyException e) {
			request.getRequestDispatcher("favourite-empty.jsp").forward(request, response);
		}
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
