package com.example.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.model.Food;


public interface Food_Re extends JpaRepository<Food,Long> {
//	Food findByEmail(String email); 
}
