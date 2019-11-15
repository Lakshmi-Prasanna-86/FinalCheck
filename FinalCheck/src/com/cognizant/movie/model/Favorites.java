package com.cognizant.movie.model;

import java.util.List;

/**
 * @author prasanna
 */
public class Favorites {
	private List<Movie> movie;
	private int noOfFavorites;

	public Favorites(List<Movie> movie, int noOfFavorites) {
		super();
		this.movie = movie;
		this.noOfFavorites = noOfFavorites;
	}

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	public int getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(int noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + noOfFavorites;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorites other = (Favorites) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (noOfFavorites != other.noOfFavorites)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Favorites [movie=" + movie + ", noOfFavorites=" + noOfFavorites
				+ "]";
	}

}
