package com.cognizant.movie.Dao;

import java.util.List;

import com.cognizant.movie.model.Movies;

public interface MoviesDao {
	public List<Movies> getMovieListAdmin();

	public List<Movies> getMovieListCustomer();

	public void modifyMovies(Movies movies);

	public Movies getmovies(Long moviesId);

}
