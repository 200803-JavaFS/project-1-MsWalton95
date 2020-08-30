package com.revature.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ers_users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ers_users_id", nullable=false)
	private int userID;

	@Column(name="ers_username",nullable=false, unique=true, length=50)
	private String username;
	//
	@Column(name="ers_password", nullable=false, length=50)
	private String password;
	//
	@Column(name="user_first_name", nullable=false, length=100)
	private String firstName;
	//
	@Column(name="user_last_name", nullable=false, length=100)
	private String lastName;
	//
	@Column(name="user_email", nullable=false, unique=true ,length=150)
	private String email;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="user_role_id", nullable=false)
	private UserRole user;
	
	@OneToMany(mappedBy="resolver", fetch=FetchType.LAZY)
	private List<Reimb> resolver;
	
	@OneToMany(mappedBy="author", fetch=FetchType.LAZY)
	private List<Reimb> author;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userID, String username, String password, String firstName, String lastName, String email,
			UserRole user, List<Reimb> resolver, List<Reimb> author) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.user = user;
		this.resolver = resolver;
		this.author = author;
	}

	
	public User(String username, String password, String firstName, String lastName, String email, UserRole user,
			List<Reimb> resolver, List<Reimb> author) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.user = user;
		this.resolver = resolver;
		this.author = author;
	}

	public User(int userID, String username, String password, String firstName, String lastName, String email,
			UserRole user) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.user = user;
	}

	public User(String username, String password, String firstName, String lastName, String email, UserRole user) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.user = user;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", user=" + user + "]";
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getUser() {
		return user;
	}

	public void setUser(UserRole user) {
		this.user = user;
	}

	public List<Reimb> getResolver() {
		return resolver;
	}

	public void setResolver(List<Reimb> resolver) {
		this.resolver = resolver;
	}

	public List<Reimb> getAuthor() {
		return author;
	}

	public void setAuthor(List<Reimb> author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + userID;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userID != other.userID)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
}
