package me.fit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
@NamedQueries({
	@NamedQuery(name = Zemlja.GET_ALL, query = "Select z from Zemlja z")
})

public class Zemlja {

	public static final String GET_ALL = "Zemlja.getAll";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zemlja_seq")
	@JsonIgnore
	public Long id;
	public String kodZemlje;
	public String naziv;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKodZemlje() {
		return kodZemlje;
	}
	public void setKodZemlje(String kodZemlje) {
		this.kodZemlje = kodZemlje;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kodZemlje == null) ? 0 : kodZemlje.hashCode());
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
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
		Zemlja other = (Zemlja) obj;
		if (kodZemlje == null) {
			if (other.kodZemlje != null)
				return false;
		} else if (!kodZemlje.equals(other.kodZemlje))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Zemlja [id=" + id + ", kodZemlje=" + kodZemlje + ", naziv=" + naziv + "]";
	}		
	
	
}
