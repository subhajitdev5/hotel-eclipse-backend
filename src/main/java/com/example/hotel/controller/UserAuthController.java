package com.example.hotel.controller;

import com.example.hotel.model.UserModel;
import com.example.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, maxAge = 3600)
public class UserAuthController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Integer id, @RequestBody UserModel userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/email")
    public UserModel getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    // Signup API
    @PostMapping("/signup")
    public UserModel signup(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    // Login API
    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody UserModel loginRequest) {
        try {
        	UserModel user = userService.getUserByEmail(loginRequest.getEmail());
        	boolean res = userService.login(loginRequest.getEmail(),loginRequest.getPassword());
        	if(res)
        	{
        		return new ResponseEntity<>(true,HttpStatus.OK);
        	}
        else {
        	return new ResponseEntity<>(false,HttpStatus.UNAUTHORIZED);
        }
        }catch(Exception e)
        	{
        		return new ResponseEntity<>(false,HttpStatus.INTERNAL_SERVER_ERROR);
        	}
        
    }
}
