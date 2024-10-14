package com.example.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hotel.model.Laundry;
import com.example.hotel.repository.Laundry_Re;

@Service
public class Laundry_Services {
	
	@Autowired
	private Laundry_Re laundryrepo;
	
	public List<Laundry> getallLaundry(){
		return laundryrepo.findAll();		
	}
	
	public Laundry addLaundry(Laundry laundry) {
		return laundryrepo.save(laundry);
	}

}
