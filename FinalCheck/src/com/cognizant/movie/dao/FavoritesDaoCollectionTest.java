package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movie;

/**
 * @author prasanna
 */
public class FavoritesDaoCollectionTest {
	public static void main(String[] args) throws FavoriteEmptyException {
		// TODO Auto-generated method stub
		testAddFavorites();
		testGetAllFavorites();
		testremoveFavorites();
	}

	static void testAddFavorites() throws FavoriteEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;
		favoritesDao.addFavorites(1, 000003);
		favoritesDao.addFavorites(1, 000004);
		List<Movie> movieList = favoritesDao.getAllFavorites(1);
		// System.out.println("Movie List : " + movieList);
		System.out.println("Added to Favorites List:");
		for (Movie movie : movieList) {
			System.out.println(movie.toString());
		}
		System.out.println();

	}

	static void testGetAllFavorites() throws FavoriteEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;
		List<Movie> movieList = favoritesDao.getAllFavorites(1);
		// System.out.println("MenuItem List : " + movieList);
		System.out.println("Favorites List:");
		for (Movie movie : movieList) {
			System.out.println(movie.toString());
		}
		System.out.println();

	}

	static void testremoveFavorites() throws FavoriteEmptyException {
		FavoritesDaoCollectionImpl favoritesDaoCollectionImpl = new FavoritesDaoCollectionImpl();
		FavoritesDao favoritesDao = favoritesDaoCollectionImpl;
		favoritesDao.removeFavorites(1, 00003);
		List<Movie> movieList = favoritesDao.getAllFavorites(1);
		System.out.println("Movie Removed From Favorites List with id=3:");
		for (Movie movie : movieList) {
			System.out.println(movie.toString());
		}
		System.out.println();

	}
}
