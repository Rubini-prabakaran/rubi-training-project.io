package com.cognizant.movie.Dao;

import java.util.List;

import java.util.ArrayList;

import java.util.HashMap;

import com.cognizant.movie.model.Favourite;

import com.cognizant.movie.model.Movies;

public class FavouriteItemDaoCollectionImpl implements FavouriteDao {

	private static HashMap<Long, Favourite> userFavourites;

	public FavouriteItemDaoCollectionImpl() {
		super();
		if (userFavourites == null) {
			userFavourites = new HashMap<>();
		}
	}

	@Override
	public void addFavouriteMovies(long userId, long moviesId) {
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();

		Movies movies = moviesDao.getmovies(moviesId);
		if (userFavourites.containsKey(userId)) {
			userFavourites.get(userId).getMovieList().add(movies);

		} else {

			Favourite favourite = new Favourite();
			List<Movies> movieList = new ArrayList<>();
			movieList.add(movies);
			favourite.setMovieList(movieList);
			userFavourites.put(userId, favourite);
		}

	}

	@Override
	public Favourite getAllFavouriteMovies(long userId) throws FavouriteEmptyException {
		// List<Movies> movieList = userFavourites.get(userId).getMovieList();
		Favourite favourite = userFavourites.get(userId);
		int total = 0;
		if (favourite == null || favourite.getMovieList().isEmpty()) {
			throw new FavouriteEmptyException();

		}
		List<Movies> movieList = favourite.getMovieList();
		for (Movies movies : movieList) {
			System.out.println(movies);

			total++;

		}
		favourite.setTotal(total);
		return favourite;
	}

	@Override
	public void removeFavouriteMovies(long userId, long MoviesId) {
		List<Movies> movieList = userFavourites.get(userId).getMovieList();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == MoviesId) {
				movieList.remove(i);
				return;
			}
		}
	}

}
