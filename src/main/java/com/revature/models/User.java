package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name="movies")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="movie_id")
	private int movieID;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="movie_description")
	private String movieDescription;
	//FetchType defines when hibernate will go to the database to fetch an associated object
	//Lazy - Hibernate will give a proxy object instead of going to the database until your
	//code actually calls for the object.
	//this only works while the object is persistent. Once it becomes detached there is 
	//no longer as Session to replace the proxy
	//Eager - returns the dependent object immediately with no proxy. This is generally safer.
	//cascade defines how the queries will maintain referential integrity.
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="dir_id")
	private UserRole dir;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int movieID, String movieName, String movieDescription, UserRole dir) {
		super();
		this.movieID = movieID;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.dir = dir;
	}
	
	
	public User(String movieName, String movieDescription, UserRole dir) {
		super();
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.dir = dir;
	}
	@Override
	public String toString() {
		return "Movie [movieID=" + movieID + ", movieName=" + movieName + ", movieDescription=" + movieDescription
				+ ", dir=" + dir + "]";
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	public UserRole getDir() {
		return dir;
	}
	public void setDir(UserRole dir) {
		this.dir = dir;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dir == null) ? 0 : dir.hashCode());
		result = prime * result + ((movieDescription == null) ? 0 : movieDescription.hashCode());
		result = prime * result + movieID;
		result = prime * result + ((movieName == null) ? 0 : movieName.hashCode());
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
		User other = (User) obj;
		if (dir == null) {
			if (other.dir != null)
				return false;
		} else if (!dir.equals(other.dir))
			return false;
		if (movieDescription == null) {
			if (other.movieDescription != null)
				return false;
		} else if (!movieDescription.equals(other.movieDescription))
			return false;
		if (movieID != other.movieID)
			return false;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		return true;
	}
	
	
}
