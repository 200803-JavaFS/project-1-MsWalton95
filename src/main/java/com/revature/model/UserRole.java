package com.revature.model;

import javax.persistence.*;

@Entity
@Table(name="ers_user_roles")
public class UserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ersUserRoleID;
	//@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	
	
	@Column(name="user_role", length=10, nullable=false)
	private String userRole;

	public UserRole() {}

	public UserRole(int ersUserRoleID, String userRole) {
		super();
		this.ersUserRoleID = ersUserRoleID;
		this.userRole = userRole;
	}

	
	public UserRole(String userRole) {
		super();
		this.userRole = userRole;
	}

	
	@Override
	public String toString() {
		return "UserRoles [ersUserRoleID=" + ersUserRoleID + ", userRole=" + userRole + "]";
	}

	
	public int getErsUserRoleID() {
		return ersUserRoleID;
	}

	public void setErsUserRoleID(int ersUserRoleID) {
		this.ersUserRoleID = ersUserRoleID;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ersUserRoleID;
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
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
		if (ersUserRoleID != other.ersUserRoleID)
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}
}
