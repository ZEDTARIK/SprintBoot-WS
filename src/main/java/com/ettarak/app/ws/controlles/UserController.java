package com.ettarak.app.ws.controlles;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ettarak.app.ws.requests.UserRequest;


@RestController
@RequestMapping("/users") // localhost:8080/users
public class UserController {

	// PUT CRUD METHODS
	

	@GetMapping
	public String getUSer() {
		return "get user was called!";
	}
	
	@PostMapping
	public String createUser(@RequestBody UserRequest userRequest) {
		return "create user was called!";
	}

	@PutMapping
	public String updateUser() {
		return "update user was called!";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called!";
	}
	
	
}
