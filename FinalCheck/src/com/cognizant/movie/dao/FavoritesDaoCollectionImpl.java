package com.cognizant.movie.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cognizant.movie.model.Favorites;
import com.cognizant.movie.model.Movie;
import com.cognizant.movie.util.DateUtil;

/**
 * @author prasanna
 */
public class FavoritesDaoCollectionImpl implements FavoritesDao {
	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		if (userFavorites == null) {
			userFavorites = new HashMap<Long, Favorites>();
			try {
				@SuppressWarnings("unused")
				Movie movie = new Movie(000005, "Avengers: End Game",
						2750760348L, true,
						DateUtil.convertToDate("02/11/2022"), "Superhero", true);
				List<Movie> movieList = new ArrayList<Movie>();
				Favorites favorites = new Favorites(movieList, 1);
				Long user = new Long(1);
				userFavorites.put(user, favorites);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addFavorites(long userId, long movieId) {
		// TODO Auto-generated method stub
		List<Movie> movieList;
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		MovieDao movieDao = movieDaoCollectionImpl;
		movieDao.getMovie(movieId);
		Movie movie = movieDao.getMovie(movieId);
		if (userFavorites.containsKey(new Long(userId))) {
			Favorites favorites = userFavorites.get(userId);
			movieList = favorites.getMovie();
			movieList.add(movie);
			favorites.setMovie(movieList);
			favorites.setNoOfFavorites(favorites.getNoOfFavorites() + 1);
			userFavorites.put(userId, favorites);
		} else {
			movieList = new CopyOnWriteArrayList<Movie>();
			movieList.add(movie);
			Favorites favorite = userFavorites.get(userId);
			int noOfFavs = favorite.getNoOfFavorites() + 1;
			Favorites favorites = new Favorites(movieList, noOfFavs);
			userFavorites.put(userId, favorites);

		}
	}

	@Override
	public List<Movie> getAllFavorites(long userId)
			throws FavoriteEmptyException {
		Favorites favorites = userFavorites.get(new Long(userId));
		List<Movie> movieList = favorites.getMovie();
		if (movieList == null || movieList.size() == 0) {
			throw new FavoriteEmptyException("Cart is empty");
		}
		int total = 0;
		for (@SuppressWarnings("unused")
		Movie movie : movieList) {
			total = total + 1;
		}
		favorites.setNoOfFavorites(total);

		return movieList;
	}

	@Override
	public void removeFavorites(long userId, long movieId) {
		if (userFavorites.containsKey(userId)) {
			Favorites favorites = userFavorites.get(userId);
			List<Movie> movieList = favorites.getMovie();
			for (Movie movie : movieList) {
				if (movie.getId() == movieId) {
					movieList.remove(movie);
				}
			}
			favorites.setMovie(movieList);
			userFavorites.put(userId, favorites);
		}
	}

}
