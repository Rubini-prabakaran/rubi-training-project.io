package com.cognizant.movie.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cognizant.movie.model.Favourite;
import com.cognizant.movie.model.Movies;

public class FavouriteDaoSqlImpl implements FavouriteDao {

	public static final String ADD_TO_FAVOURITE = "INSERT INTO movie_cruiser.favourites( fv_us_id, fv_gr_id) VALUES ( ?,?)";

	public void addFavouriteMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(ADD_TO_FAVOURITE);
			statement.setLong(1, userId);
			statement.setLong(2, moviesId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of Rows Affected" + noOfRows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

			}
		}
	}

	public static final String GET_ALL_FAVOURITE_ITEM = "SELECT * from favourites\r\n"
			+ " inner join movie_list on mo_id=fv_gr_id inner join user on us_id=favourites.fv_us_id 	where us_id=?";

	public static final String GET_TOTAL = "SELECT user.us_id,count(*) as mo_fav from favourites\r\n"
			+ "inner join movie_list on movie_list.mo_id=favourites.fv_gr_id\r\n"
			+ "inner join user on user.us_id=favourites.fv_us_id\r\n" + "where user.us_id=?";

	public Favourite getAllFavouriteMovies(long userId) throws FavouriteEmptyException {
		ArrayList<Movies> movieList = new ArrayList<Movies>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTotal = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;
		Movies movies = null;
		Favourite favourite = new Favourite();
		try {
			preparedStatement = connection.prepareStatement(GET_ALL_FAVOURITE_ITEM);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_gross"));
				movies.setActive(resultSet.getString("mo_active").equals("Yes"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setHasTeaser(resultSet.getString("mo_has_teaser").equals("Yes"));
				movieList.add(movies);
			}
			if (movieList.size() == 0) {
				throw new FavouriteEmptyException();
			}
			favourite.setMovieList(movieList);

			preparedStatementTotal = connection.prepareStatement(GET_TOTAL);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery();
			int total = 0;
			while (resultSetTotal.next()) {
				total = resultSetTotal.getInt("mo_fav");
			}
			favourite.setTotal(total);
		} catch (SQLException e) {

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSetTotal != null) {
					resultSetTotal.close();
				}
				if (preparedStatementTotal != null) {
					preparedStatementTotal.close();

					if (connection != null) {
						connection.close();
					}
				}
			} catch (SQLException e) {

			}
		}
		return favourite;
	}

	public static final String DELETE_FAVOURITE_LIST = "delete from favourites where fv_us_id=? and fv_gr_id=? limit 1";

	public void removeFavouriteMovies(long userId, long MoviesId) {

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(DELETE_FAVOURITE_LIST);
			statement.setLong(1, userId);
			statement.setLong(2, MoviesId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of Rows Affected" + noOfRows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}

				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

			}
		}
	}
}
