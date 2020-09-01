package com.revature.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
public class ReimbType implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int typeID;
	@Column(nullable=false, length=10)
	private String type;
	@OneToMany(mappedBy="type")
    private Set<Reimb> reimbs;

	public ReimbType() {
		// TODO Auto-generated constructor stub
	}

	public ReimbType(int typeID, String type, Set<Reimb> reimbs) {
		super();
		this.typeID = typeID;
		this.type = type;
		this.reimbs = reimbs;
	}

	public ReimbType(int typeID, String type) {
		super();
		this.typeID = typeID;
		this.type = type;
	}

	public ReimbType(String type) {
		super();
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReimbType [typeID=" + typeID + ", type=" + type + "]";
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
