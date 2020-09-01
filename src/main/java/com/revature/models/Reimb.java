package com.revature.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reimb implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimbID;
	@Column(nullable=false)
	private double amount;
	@Column(nullable=false)
	private Timestamp submitted;
	private Timestamp resolved;
	@Column(length=250)
	private String description;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=false)
	private ReimbStatus status;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=false)
	private ReimbType type;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=false)
	private Users author;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(nullable=true)
	private Users resolver;
	public Reimb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reimb(int reimbID, double amount, Timestamp submitted, Timestamp resolved, String description, ReimbStatus status,
			ReimbType type, Users author, Users resolver) {
		super();
		this.reimbID = reimbID;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.status = status;
		this.type = type;
		this.author = author;
		this.resolver = resolver;
	}
	public Reimb(double amount, Timestamp submitted, Timestamp resolved, String description, ReimbStatus status, ReimbType type,
			Users author, Users resolver) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.status = status;
		this.type = type;
		this.author = author;
		this.resolver = resolver;
	}
	
	//Insert
	public Reimb(double amount, Timestamp submitted, String description, ReimbStatus status, ReimbType type, Users author) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.status = status;
		this.type = type;
		this.author = author;
	}
	
	//UpTimestamp
	public Reimb(int reimbID, Timestamp resolved, ReimbStatus status, Users resolver) {
		super();
		this.reimbID = reimbID;
		this.resolved = resolved;
		this.status = status;
		this.resolver = resolver;
	}
	@Override
	public String toString() {
		return "Reimb [reimbID=" + reimbID + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + "]";
	}
	public int getReimbID() {
		return reimbID;
	}
	public void setReimbID(int reimbID) {
		this.reimbID = reimbID;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ReimbStatus getStatus() {
		return status;
	}
	public void setStatus(ReimbStatus status) {
		this.status = status;
	}
	public ReimbType getType() {
		return type;
	}
	public void setType(ReimbType type) {
		this.type = type;
	}
	public Users getAuthor() {
		return author;
	}
	public void setAuthor(Users author) {
		this.author = author;
	}
	public Users getResolver() {
		return resolver;
	}
	public void setResolver(Users resolver) {
		this.resolver = resolver;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + reimbID;
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Reimb other = (Reimb) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reimbID != other.reimbID)
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (resolver == null) {
			if (other.resolver != null)
				return false;
		} else if (!resolver.equals(other.resolver))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitted == null) {
			if (other.submitted != null)
				return false;
		} else if (!submitted.equals(other.submitted))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
}
