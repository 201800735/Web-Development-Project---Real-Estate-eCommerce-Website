package com.neu.project.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sellertable")
public class Seller {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sellerid")
	private long id;
	
	@Column(name="city")
	private String city;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="seller_id")
	private Set<Property> properties = new HashSet<Property>();
	
	public Seller(String city)
	{
		this.city = city;
		this.properties = new HashSet<Property>();
	}
	
	Seller()
	{
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}
	
	public void addProperty(Property property)
	{
		getProperties().add(property);
	}

}
