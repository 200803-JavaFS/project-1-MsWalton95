package com.revature.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ers_user_roles")
public class UserRole {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ers_user_role_id")
	private int roleID;
	
	@Column(name="user_role", nullable=false, length=20)
	private String userRole;
	
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<User> users;
	
	public UserRole() {
		// TODO Auto-generated constructor stub
	}

	public UserRole(int roleID, String userRole, List<User> users) {
		super();
		this.roleID = roleID;
		this.userRole = userRole;
		this.users = users;
	}

	public UserRole(String userRole, List<User> users) {
		super();
		this.userRole = userRole;
		this.users = users;
	}
	
	public UserRole(String userRole) {
		super();
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserRole [roleID=" + roleID + ", userRole=" + userRole + "]";
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roleID;
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	
}
