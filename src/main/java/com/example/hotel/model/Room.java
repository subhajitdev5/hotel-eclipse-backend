package com.example.hotel.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String roomType;
	private String checkindate;
	private String checkoutdate;
	private double totalprice;
	
	
	
	//Constructors
	
	public Room() {}
	public Room(Long id, String email, String roomType, String checkindate, String checkoutdate, double totalprice) {
		super();
		this.id = id;
		this.email = email;
		this.roomType = roomType;
		this.checkindate = checkindate;
		this.checkoutdate = checkoutdate;
		this.totalprice = totalprice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getCheckindate() {
		return checkindate;
	}
	public void setCheckindate(String checkindate) {
		this.checkindate = checkindate;
	}
	public String getCheckoutdate() {
		return checkoutdate;
	}
	public void setCheckoutdate(String checkoutdate) {
		this.checkoutdate = checkoutdate;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
}
	
