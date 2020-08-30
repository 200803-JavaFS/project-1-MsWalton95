package com.revature.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ers_reimbursement_status")
public class ReimbStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_status_id", nullable=false)
	private int statusID;
	
	@Column(name="reimb_status", nullable=false, length=10)
	private String status;
	
	@OneToMany(mappedBy="status", fetch=FetchType.EAGER)
	private List<Reimb> reimb;

	public ReimbStatus() {
		// TODO Auto-generated constructor stub
	}

	public ReimbStatus(int statusID, String status, List<Reimb> reimb) {
		super();
		this.statusID = statusID;
		this.status = status;
		this.reimb = reimb;
	}

	public ReimbStatus(String status, List<Reimb> reimb) {
		super();
		this.status = status;
		this.reimb = reimb;
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

	public List<Reimb> getReimb() {
		return reimb;
	}

	public void setReimb(List<Reimb> reimb) {
		this.reimb = reimb;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimb == null) ? 0 : reimb.hashCode());
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
		if (reimb == null) {
			if (other.reimb != null)
				return false;
		} else if (!reimb.equals(other.reimb))
			return false;
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
