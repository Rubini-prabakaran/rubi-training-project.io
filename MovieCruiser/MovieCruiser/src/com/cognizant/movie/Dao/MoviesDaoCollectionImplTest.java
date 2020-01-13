package com.cognizant.movie.Dao;

import java.util.List;

import com.cognizant.movie.model.Movies;

import com.cognizant.movie.util.DateUtil;

public class MoviesDaoCollectionImplTest {

	public static void testGetMovieListAdmin() {
		// System.out.println("movie list for Admin");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> movieList = moviesDao.getMovieListAdmin();
		for (Movies movies : movieList) {
			System.out.println(movies);
			// DateUtil().convertToString(movies.getDateOfLaunch()));
		}
	}

	public static void testGetMovieListCustomer() {
		// System.out.println("movie List for Customer");
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		List<Movies> movieList = moviesDao.getMovieListCustomer();
		for (Movies movies : movieList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovies() {

		Movies list = new Movies(5L, "Avengers", 275076036, false, new DateUtil().convertToDate("01/12/2019"),
				"Super Hero", true);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovies(list);
		// System.out.println("Modified List ***");
		testGetMovieListAdmin();
		Movies modified_List = moviesDao.getmovies(list.getId());
		System.out.println("Modified LIST Detail\n" + modified_List);
	}

	public static void main(String[] args) {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovies();

	}
}
