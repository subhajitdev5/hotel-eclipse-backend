package com.example.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Laundry {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private String Email;
	private int noofclothes;
	private String typeofwash;
	private double price;
	
	public Laundry() {}

	public Laundry(Long id, String email, int noofclothes, String typeofwash, double price) {
		
		Id = id;
		Email = email;
		this.noofclothes = noofclothes;
		this.typeofwash = typeofwash;
		this.price = price;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getNoofclothes() {
		return noofclothes;
	}

	public void setNoofclothes(int noofclothes) {
		this.noofclothes = noofclothes;
	}

	public String getTypeofwash() {
		return typeofwash;
	}

	public void setTypeofwash(String typeofwash) {
		this.typeofwash = typeofwash;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
