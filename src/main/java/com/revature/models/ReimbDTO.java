package com.revature.models;

import java.sql.Timestamp;

public class ReimbDTO {
	
	private int reimbID;
	private double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private String status;
	private String type;
	private String author;
	private String resolver;
	
	public ReimbDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbDTO(int reimbID, double amount, Timestamp submitted, Timestamp resolved, String description, String status,
			String type, String author, String resolver) {
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
	public ReimbDTO(double amount, Timestamp submitted, Timestamp resolved, String description, String status, String type,
			String author, String resolver) {
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
	public ReimbDTO(double amount, Timestamp submitted, String description, String status, String type, String author) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.status = status;
		this.type = type;
		this.author = author;
	}
	
	//UpTimestamp
	public ReimbDTO(int reimbID, Timestamp resolved, String status, String resolver) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getResolver() {
		return resolver;
	}
	public void setResolver(String resolver) {
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
		ReimbDTO other = (ReimbDTO) obj;
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
