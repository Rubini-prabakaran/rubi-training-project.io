package com.cognizant.movie.Dao;



import com.cognizant.movie.model.Favourite;


public interface FavouriteDao {

	public void addFavouriteMovies(long userId, long moviesId);

	public Favourite getAllFavouriteMovies(long userId) throws FavouriteEmptyException;

	public void removeFavouriteMovies(long userId, long MoviesId);

}
