package com.revature.models;

import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="directors")
public class UserRole {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dir_id")
	private int dirID;
	
	@Column(name="dir_first_name")
	private String dirFName;
	
	@Column(name="dir_last_name")
	private String dirLName;
	
	@OneToMany(mappedBy="dir", fetch=FetchType.EAGER)
	private List<User> movies;
	
	public UserRole() {
		// TODO Auto-generated constructor stub
	}

	public UserRole(int dirID, String dirFName, String dirLName, List<User> movies) {
		super();
		this.dirID = dirID;
		this.dirFName = dirFName;
		this.dirLName = dirLName;
		this.movies = movies;
	}

	public UserRole(String dirFName, String dirLName, List<User> movies) {
		super();
		this.dirFName = dirFName;
		this.dirLName = dirLName;
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Director [dirID=" + dirID + ", dirFName=" + dirFName + ", dirLName=" + dirLName + ", movies=" + movies
				+ "]";
	}

	public int getDirID() {
		return dirID;
	}

	public void setDirID(int dirID) {
		this.dirID = dirID;
	}

	public String getDirFName() {
		return dirFName;
	}

	public void setDirFName(String dirFName) {
		this.dirFName = dirFName;
	}

	public String getDirLName() {
		return dirLName;
	}

	public void setDirLName(String dirLName) {
		this.dirLName = dirLName;
	}

	public List<User> getMovies() {
		return movies;
	}

	public void setMovies(List<User> movies) {
		this.movies = movies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dirFName == null) ? 0 : dirFName.hashCode());
		result = prime * result + dirID;
		result = prime * result + ((dirLName == null) ? 0 : dirLName.hashCode());
		result = prime * result + ((movies == null) ? 0 : movies.hashCode());
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
		UserRole other = (UserRole) obj;
		if (dirFName == null) {
			if (other.dirFName != null)
				return false;
		} else if (!dirFName.equals(other.dirFName))
			return false;
		if (dirID != other.dirID)
			return false;
		if (dirLName == null) {
			if (other.dirLName != null)
				return false;
		} else if (!dirLName.equals(other.dirLName))
			return false;
		if (movies == null) {
			if (other.movies != null)
				return false;
		} else if (!movies.equals(other.movies))
			return false;
		return true;
	}
	
	
}
