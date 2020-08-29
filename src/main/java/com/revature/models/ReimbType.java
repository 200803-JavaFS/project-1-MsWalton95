package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ers_reimbursement_type")
public class ReimbType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="reimb_type_id", nullable=false)
	private int typeID;
	
	@Column(name="reimb_type", nullable=false, length=10)
	private String type;
	
	@OneToMany(mappedBy="type", fetch=FetchType.LAZY)
	private List<Reimb> reimb;

	public ReimbType() {
		// TODO Auto-generated constructor stub
	}

	public ReimbType(int typeID, String type, List<Reimb> reimb) {
		super();
		this.typeID = typeID;
		this.type = type;
		this.reimb = reimb;
	}

	public ReimbType(String type, List<Reimb> reimb) {
		super();
		this.type = type;
		this.reimb = reimb;
	}
	

	public ReimbType(String type) {
		super();
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReimbType [typeID=" + typeID + ", type=" + type + ", reimb=" + reimb + "]";
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + typeID;
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
		ReimbType other = (ReimbType) obj;
		if (reimb == null) {
			if (other.reimb != null)
				return false;
		} else if (!reimb.equals(other.reimb))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typeID != other.typeID)
			return false;
		return true;
	}
	
	
}
