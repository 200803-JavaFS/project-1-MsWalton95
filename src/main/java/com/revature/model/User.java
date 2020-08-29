package com.revature.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ers_users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OneToMany(mappedBy="reimbAuthor, reimbResolver", fetch=FetchType.EAGER)
	@Column(name="ers_user_id", nullable=false)
	private int ersUserID;
	
	@Column(name="ers_username", length=50, nullable=false, unique=true)
	private String ersUsername;
	
	@Column(name="ers_password", length=50, nullable=false)
	private String ersPassword;
	
	@Column(name="user_first_name", length=100, nullable=false)
	private String userFirstName;
	
	@Column(name="user_last_name", length=100, nullable=false)
	private String userLastName;
	
	@Column(name="user_email", length=150, nullable=false, unique=true)
	private String userEmail;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_role_id", nullable=false)
	private UserRole userRoleID;

	public User() {}

	public User(int ersUserID, String ersUsername, String ersPassword, String userFirstName, String userLastName,
			String userEmail, UserRole userRoleID) {
		super();
		this.ersUserID = ersUserID;
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleID = userRoleID;
	}

	public User(String ersUsername, String ersPassword, String userFirstName, String userLastName, String userEmail,
			UserRole userRoleID) {
		super();
		this.ersUsername = ersUsername;
		this.ersPassword = ersPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleID = userRoleID;
	}

	
	@Override
	public String toString() {
		return "Users [ersUserID=" + ersUserID + ", ersUsername=" + ersUsername + ", ersPassword=" + ersPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userRoleID=" + userRoleID + "]";
	}

	public int getErsUserID() {
		return ersUserID;
	}

	public void setErsUserID(int ersUserID) {
		this.ersUserID = ersUserID;
	}

	public String getErsUsername() {
		return ersUsername;
	}

	public void setErsUsername(String ersUsername) {
		this.ersUsername = ersUsername;
	}

	public String getErsPassword() {
		return ersPassword;
	}

	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public UserRole getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(UserRole userRoleID) {
		this.userRoleID = userRoleID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ersPassword == null) ? 0 : ersPassword.hashCode());
		result = prime * result + ersUserID;
		result = prime * result + ((ersUsername == null) ? 0 : ersUsername.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFirstName == null) ? 0 : userFirstName.hashCode());
		result = prime * result + ((userLastName == null) ? 0 : userLastName.hashCode());
		result = prime * result + ((userRoleID == null) ? 0 : userRoleID.hashCode());
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
		if (ersPassword == null) {
			if (other.ersPassword != null)
				return false;
		} else if (!ersPassword.equals(other.ersPassword))
			return false;
		if (ersUserID != other.ersUserID)
			return false;
		if (ersUsername == null) {
			if (other.ersUsername != null)
				return false;
		} else if (!ersUsername.equals(other.ersUsername))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userFirstName == null) {
			if (other.userFirstName != null)
				return false;
		} else if (!userFirstName.equals(other.userFirstName))
			return false;
		if (userLastName == null) {
			if (other.userLastName != null)
				return false;
		} else if (!userLastName.equals(other.userLastName))
			return false;
		if (userRoleID == null) {
			if (other.userRoleID != null)
				return false;
		} else if (!userRoleID.equals(other.userRoleID))
			return false;
		return true;
	}

}
