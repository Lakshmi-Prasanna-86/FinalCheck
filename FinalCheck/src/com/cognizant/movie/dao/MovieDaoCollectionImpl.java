package com.cognizant.movie.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.util.DateUtil;

/**
 * @author prasanna
 */
public class MovieDaoCollectionImpl implements MovieDao {
	List<Movie> movieList;

	public MovieDaoCollectionImpl() {
		if (movieList == null) {
			try {
				movieList = new ArrayList<Movie>();
				movieList.add(new Movie(000001, "Avatar", 2787965087L, true,
						DateUtil.convertToDate("15/03/2017"),
						"Science Fiction", true));
				movieList.add(new Movie(000002, "The Avengers", 1518812988L,
						true, DateUtil.convertToDate("23/12/2017"),
						"Superhero", false));
				movieList
				.add(new Movie(000003, "Titanic", 2187463944L, true,
						DateUtil.convertToDate("21/08/2018"),
						"Romance", false));
				movieList.add(new Movie(000004, "Jurasic World", 16717132018L,
						false, DateUtil.convertToDate("02/07/2017"),
						"Science Fiction", true));
				movieList
				.add(new Movie(000005, "Avengers: End Game",
						2750760348L, true, DateUtil
						.convertToDate("02/11/2022"),
						"Superhero", true));
			} catch (Exception e) {
				System.out.println(e);

			}
		}
	}

	@Override
	public List<Movie> getMovieListAdmin() {
		// TODO Auto-generated method stub

		return movieList;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		// TODO Auto-generated method stub
		List<Movie> movieListCust = new ArrayList<Movie>();
		Date today = new Date();
		for (Movie movie : movieList) {
			if (movie.getDateOfLaunch().getTime() <= today.getTime()
					&& movie.isActive()) {
				movieListCust.add(movie);
			}
		}
		return movieListCust;
	}

	@Override
	public void modifyMovie(Movie movie) {
		// TODO Auto-generated method stub
		for (Movie movieForModification : movieList) {
			if (movie.getId() == movieForModification.getId()) {
				movieForModification.setTitle(movie.getTitle());
				movieForModification.setGenre(movie.getGenre());
				movieForModification.setDateOfLaunch(movie.getDateOfLaunch());
				movieForModification.setHasTeaser(movie.getHasTeaser());
				movieForModification.setBoxOffice(movie.getBoxOffice());
				movieForModification.setActive(movie.isActive());

			}
		}
	}

	@Override
	public Movie getMovie(long movieId) {
		// TODO Auto-generated method stub
		for (Movie movie : movieList) {
			if (movieId == movie.getId()) {
				return movie;
			}
		}
		return null;
	}

}
