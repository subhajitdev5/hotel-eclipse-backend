package com.example.hotel.model;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Food {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private String  Email;
	private String foodtype;
	private int noofguests;
	private String meal;
	private double price;
	
	public Food() {}
	
	public Food(Long id, String email, String foodtype, int noofguests, String meal, double price) {
	
		this.Email = email;
		this.foodtype = foodtype;
		this.noofguests = noofguests;
		this.meal = meal;
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
	public String getFoodtype() {
		return foodtype;
	}
	public void setFoodtype(String foodtype) {
		this.foodtype = foodtype;
	}
	public int getNoofguests() {
		return noofguests;
	}
	public void setNoofguests(int noofguests) {
		this.noofguests = noofguests;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
