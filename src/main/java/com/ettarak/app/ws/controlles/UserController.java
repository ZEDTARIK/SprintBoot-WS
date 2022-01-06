package com.ettarak.app.ws.controlles;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ettarak.app.ws.requests.UserRequest;
import com.ettarak.app.ws.responses.UserResponse;
import com.ettarak.app.ws.services.UserService;
import com.ettarak.app.ws.shared.dto.UserDto;


@RestController
@RequestMapping("/users") 
public class UserController {

	
	@Autowired
	UserService userService;
	

	@GetMapping
	public String getUSer() {
		return "get user was called!";
	}
	
	@PostMapping
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		//The part  Representation layer 
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);
		
		// The part Service 
		UserDto createUser = userService.createUser(userDto);
		
		// The part Response
		UserResponse userResponse = new UserResponse();
		BeanUtils.copyProperties(createUser, userResponse);
		
		return userResponse;
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
