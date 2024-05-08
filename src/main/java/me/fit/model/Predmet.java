package me.fit.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Predmet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "predmet_seq")
	public Long id;
	
	public String naziv;
	public String brojKredita;
	public String dodatniUslov;
	
	@ManyToMany(mappedBy = "predmeti")
    private Set<Student> studenti;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getBrojKredita() {
		return brojKredita;
	}
	public void setBrojKredita(String brojKredita) {
		this.brojKredita = brojKredita;
	}
	public String getDodatniUslov() {
		return dodatniUslov;
	}
	public void setDodatniUslov(String dodatniUslov) {
		this.dodatniUslov = dodatniUslov;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Predmet other = (Predmet) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		return "Predmet [id=" + id + ", naziv=" + naziv + ", brojKredita=" + brojKredita + ", dodatniUslov="
				+ dodatniUslov + "]";
	}
	
	
	
	
	
}
