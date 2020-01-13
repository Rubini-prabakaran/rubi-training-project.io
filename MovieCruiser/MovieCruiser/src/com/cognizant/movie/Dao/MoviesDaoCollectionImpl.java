package com.cognizant.movie.Dao;

import com.cognizant.movie.model.Movies;

import com.cognizant.movie.util.DateUtil;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

public class MoviesDaoCollectionImpl implements MoviesDao {
	private static List<Movies> movieList;

	public MoviesDaoCollectionImpl() {
		super();
		if (movieList == null) {
			movieList = new ArrayList<Movies>();
			Movies listOne = new Movies(1L, "Avatar", 27879650, true, new DateUtil().convertToDate("15/03/2017"),
					"Science Fiction", true);
			Movies listTwo = new Movies(2L, "The Avengers", 15188129, true, new DateUtil().convertToDate("23/12/2017"),
					"Super Hero", false);
			Movies listThree = new Movies(3L, "Titanic", 21874639, true, new DateUtil().convertToDate("21/08/2017"),
					"Romance", false);
			Movies listFour = new Movies(4L, "Jurrasic World", 16717132, false,
					new DateUtil().convertToDate("12/12/2019"), "Science Fiction", true);
			Movies listFive = new Movies(5L, "Avengers:End Game", 27507603, true,
					new DateUtil().convertToDate("02/11/2022"), "Super Hero", true);
			movieList.add(listOne);
			movieList.add(listTwo);
			movieList.add(listThree);
			movieList.add(listFour);
			movieList.add(listFive);
		}

	}

	@Override
	public List<Movies> getMovieListAdmin() {
		return movieList;
	}

	@Override
	public List<Movies> getMovieListCustomer() {
		ArrayList<Movies> filteredMovies = new ArrayList<Movies>();
		for (Movies movies : movieList) {
			if (movies.getDateOfLaunch().before(new Date())) {
				if (movies.isActive()) {
					filteredMovies.add(movies);
				}
			}
		}
		return filteredMovies;
	}

	@Override
	public void modifyMovies(Movies movies) {

		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movies.getId()) {
				movieList.set(i, movies);
			}
		}
	}

	@Override
	public Movies getmovies(Long moviesId) {
		for (Movies movies : movieList) {
			if (movies.getId() == moviesId) {
				return movies;
			}
		}
		return null;
	}

}
