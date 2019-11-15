package com.cognizant.movie.dao;

import java.util.*;

import com.cognizant.movie.model.Movie;

/**
 * @author prasanna
 */
public interface FavoritesDao {
	void addFavorites(long userId, long movieId);

	List<Movie> getAllFavorites(long userId) throws FavoriteEmptyException;

	void removeFavorites(long userId, long movieId);
}
