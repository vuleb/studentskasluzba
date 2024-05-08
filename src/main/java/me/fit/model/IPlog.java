package me.fit.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IPlog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iplog_seq")
	public Long id;
	public String ipString;
	public String ipType;
	public Date createdDate;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIpString() {
		return ipString;
	}


	public void setIpString(String ipString) {
		this.ipString = ipString;
	}


	public String getIpType() {
		return ipType;
	}


	public void setIpType(String ipType) {
		this.ipType = ipType;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ipString == null) ? 0 : ipString.hashCode());
		result = prime * result + ((ipType == null) ? 0 : ipType.hashCode());
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
		IPlog other = (IPlog) obj;
		if (ipString == null) {
			if (other.ipString != null)
				return false;
		} else if (!ipString.equals(other.ipString))
			return false;
		if (ipType == null) {
			if (other.ipType != null)
				return false;
		} else if (!ipType.equals(other.ipType))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "IPlog [id=" + id + ", ipString=" + ipString + ", ipType=" + ipType + ", createdDate=" + createdDate
				+ "]";
	}


	
	
	
}
