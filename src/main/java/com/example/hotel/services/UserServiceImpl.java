package com.example.hotel.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.hotel.model.UserModel;
import com.example.hotel.repository.UserRepository;

public class UserServiceImpl implements UserServiceInterface {

	UserRepository Userrepo;
	@Override
	public boolean login(String email, String password) {
		UserModel user = Userrepo.findByEmail(email);
		if (user==null) {
            return false;
        } 
		if(user.getPassword().equals(password))
		{
			return true;
		}
		else {
            return false;
        }
	}

}
