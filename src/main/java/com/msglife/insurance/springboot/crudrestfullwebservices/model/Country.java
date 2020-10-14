package com.msglife.insurance.springboot.crudrestfullwebservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "country_name")
	private String countryName;
	

	@Column(name = "death_rate")
	private float deathRate;
	
	@Column(name = "country_code")
	private String countryCode;
	
	public Country() {
		super();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
	public float getDeathRate() {
		return deathRate;
	}
	
	public void setDeathRate(float deathRate) {
		this.deathRate = deathRate;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	

}
