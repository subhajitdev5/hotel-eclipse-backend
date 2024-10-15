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
    public ResponseEntity<?> login(@RequestBody UserModel loginRequest) {
        try {
            // Validate input
            if (loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
                return ResponseEntity.badRequest().body("Email and password must not be empty.");
            }

            UserModel user = userService.getUserByEmail(loginRequest.getEmail());
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
            }

            boolean validPassword = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
            if (validPassword) {
                // Return user data or a token if applicable
                return ResponseEntity.ok(user); // You can return user details or a token here
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
            }
        } catch (Exception e) {
            // Log the exception (consider using a logging framework)
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login.");
        }
    }


}
