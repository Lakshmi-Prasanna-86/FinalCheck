package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movie;

/**
 * @author prasanna
 */
public interface MovieDao {
	List<Movie> getMovieListAdmin();

	List<Movie> getMovieListCustomer();

	void modifyMovie(Movie movie);

	Movie getMovie(long movieId);
}
