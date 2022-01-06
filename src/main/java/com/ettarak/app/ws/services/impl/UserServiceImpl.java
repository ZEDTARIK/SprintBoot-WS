package com.ettarak.app.ws.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ettarak.app.ws.entities.UserEntity;
import com.ettarak.app.ws.repositories.UserRepository;
import com.ettarak.app.ws.services.UserService;
import com.ettarak.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto user) {
		// TODO Auto-generated method stub
		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(user, userEntity);
		userEntity.setUserId("user test id");
		userEntity.setEncryptedPassword("password test user");
		
		UserEntity newUser= userRepository.save(userEntity);
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(newUser, userDto);
		
				
		return userDto;
	}

}
