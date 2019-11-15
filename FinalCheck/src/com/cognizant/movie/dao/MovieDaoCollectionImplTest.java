package com.cognizant.movie.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.util.DateUtil;

/**
 * @author prasanna
 */
public class MovieDaoCollectionImplTest {
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovie();
		testGetMovie();
	}

	static void testGetMovieListAdmin() {
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		System.out.println("Movie List Admin:");
		List<Movie> movies = movieDaoCollectionImpl.getMovieListAdmin();
		// System.out.println("Menu Item List "+menuItemDaoCollectionImpl.getMenuItemListAdmin());
		// it also prints directly all the list items
		for (Movie movie : movies) {
			System.out.println(movie.toString());
		}
		System.out.println();
	}

	static void testGetMovieListCustomer() {
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		System.out.println("Movie List Customer:");
		List<Movie> movies = movieDaoCollectionImpl.getMovieListCustomer();
		for (Movie movie : movies) {
			System.out.println(movie.toString());
		}
		System.out.println();
	}

	static void testModifyMovie() throws ParseException {
		Movie movie = new Movie(000001, "Bahubali", 8888888888L, true,
				DateUtil.convertToDate("08/06/2016"), "Drama", true);

		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();

		MovieDao movieDao = movieDaoCollectionImpl;

		movieDao.modifyMovie(movie);
		System.out.println("Modified Movie1 Details are :\n"
				+ movieDao.getMovie(1));
		System.out.println();

	}

	static void testGetMovie() {
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		MovieDao movieDao = movieDaoCollectionImpl;
		System.out.println("GetMovie with id=2:");
		System.out.println(movieDao.getMovie(2));
		System.out.println();

	}
}
