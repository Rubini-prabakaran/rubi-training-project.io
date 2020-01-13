package com.cognizant.movie.Dao;

import com.cognizant.movie.model.Favourite;
import com.cognizant.movie.model.Movies;

public class FavouriteItemDaoCollectionImplTest {

	public static void testAddFavouriteMovies() throws FavouriteEmptyException {
		FavouriteDao favouriteDao = new FavouriteItemDaoCollectionImpl();
		favouriteDao.addFavouriteMovies(1, 2L);
		favouriteDao.addFavouriteMovies(1, 5L);
		favouriteDao.addFavouriteMovies(2, 1L);
		favouriteDao.addFavouriteMovies(2, 3L);
		Favourite movieListCustomer = favouriteDao.getAllFavouriteMovies(1);
		// System.out.println("user Added favourite Movies for checkout");

		for (Movies movies : movieListCustomer.getMovieList()) {
			System.out.println(movies);

		}
	}

	public static void testRemoveFavouriteMovies() throws FavouriteEmptyException {
		FavouriteDao favouriteDao = new FavouriteItemDaoCollectionImpl();
		System.out.println("Favourite Movie list for customer after remove");
		try {
			favouriteDao.removeFavouriteMovies(1, 2l);
			favouriteDao.removeFavouriteMovies(1, 5L);
			favouriteDao.removeFavouriteMovies(1, 3l);
			Favourite movieListCustomer = favouriteDao.getAllFavouriteMovies(1);

			for (Movies movies : movieListCustomer.getMovieList()) {
				System.out.println(movies);

			}

		} catch (FavouriteEmptyException e) {
			// System.out.println(e.getMessage());
		}
	}

	public static void testGetAllFavouriteMovies() {

	}

	public static void main(String[] args) throws FavouriteEmptyException {
		testAddFavouriteMovies();
		testRemoveFavouriteMovies();

	}

}
