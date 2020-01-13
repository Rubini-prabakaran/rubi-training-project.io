package com.cognizant.movie.Dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;
import com.cognizant.movie.model.Favourite;
import com.cognizant.movie.model.Movies;

public class FavouriteDaoSqlImplTest {
	public static void testaddFavouriteMovies() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long userId = 1;
		System.out.println("Enter the Cart Id to Add");
		long menuItemId = Long.parseLong(bf.readLine());
		new FavouriteDaoSqlImpl().addFavouriteMovies(userId, menuItemId);
	}

	public static void testremoveFavouriteMovies() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		long userId = 1;
		System.out.println("Enter the Cart Id to remove");
		long MoviesId = Long.parseLong(bf.readLine());
		new FavouriteDaoSqlImpl().removeFavouriteMovies(userId, MoviesId);
	}

	public static void testgetAllFavouriteMovies() throws FavouriteEmptyException, NumberFormatException, IOException {
		long userId = 1L;
		Favourite favourite = new FavouriteDaoSqlImpl().getAllFavouriteMovies(userId);
		System.out.println(favourite.getMovieList());
		List<Movies> movieList = favourite.getMovieList();
		// Double total=favourite.getTotal();
		// DecimalFormat df = new DecimalFormat("#.00");
		// SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		System.out.format("%-5s%-15s%-15s%-15s%-20s%-15s%-15s\n", "ID", "TITLE", "GROSS", "GENRE");
		/*
		 * String HasTeaser; String Active;
		 */

		/*
		 * if(movies.isHasTeaser() == true) { HasTeaser="Yes"; }else { HasTeaser="No"; }
		 * 
		 * if(movies.isActive()== true) { Active="Yes"; }else { Active="No"; }
		 */
		// //
		for (Movies movies : movieList) {
			System.out.format("%-5s%-15s%-15s%-15s\n", movies.getId(), movies.getTitle(), movies.getGross(),
					movies.getGenre());
		}
		System.out.println("No of Favourites= " + favourite.getTotal());
	}

	public static void main(String[] args) throws IOException, ParseException, FavouriteEmptyException {
		testaddFavouriteMovies();
		testremoveFavouriteMovies();
		testgetAllFavouriteMovies();

	}

}
