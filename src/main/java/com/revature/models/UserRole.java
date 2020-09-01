package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class UserRole implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleID;
	@Column(nullable=false, length=20)
	private String userRole;
	@OneToMany(mappedBy="roleID")
    private Set<Users> users;
	
	public UserRole() {
		// TODO Auto-generated constructor stub
	}
	
	public UserRole(int roleID, String userRole) {
		super();
		this.roleID = roleID;
		this.userRole = userRole;
	}

	public UserRole(String userRole) {
		super();
		this.userRole = userRole;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	

	@Override
	public String toString() {
		return "UserRole [roleID=" + roleID + ", userRole=" + userRole + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roleID;
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
		if (roleID != other.roleID)
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		return true;
	}



	
}
