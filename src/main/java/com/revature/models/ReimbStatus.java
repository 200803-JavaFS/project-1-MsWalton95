package com.revature.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class ReimbStatus implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int statusID;
	@Column(nullable=false, length=10)
	private String status;
	@OneToMany(mappedBy="status", cascade= CascadeType.ALL)
    private List<Reimb> reimbs;
	
	public ReimbStatus() {}

	public ReimbStatus(int statusID, String status) {
		super();
		this.statusID = statusID;
		this.status = status;
	}

	public ReimbStatus(String status) {
		super();
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReimbStatus [statusID=" + statusID + ", status=" + status + "]";
	}

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + statusID;
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
		ReimbStatus other = (ReimbStatus) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusID != other.statusID)
			return false;
		return true;
	}

}
