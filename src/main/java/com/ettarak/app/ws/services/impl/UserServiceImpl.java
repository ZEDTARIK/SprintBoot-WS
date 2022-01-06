package com.ettarak.app.ws.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ettarak.app.ws.entities.UserEntity;
import com.ettarak.app.ws.repositories.UserRepository;
import com.ettarak.app.ws.services.UserService;
import com.ettarak.app.ws.shared.Utils;
import com.ettarak.app.ws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	Utils utils;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity checkedEmail = userRepository.findByEmail(user.getEmail());
		
		if(checkedEmail != null) throw new RuntimeException("Email Already Exist !");
		
		UserEntity userEntity = new UserEntity();
		
		BeanUtils.copyProperties(user, userEntity);
		userEntity.setUserId(utils.generateUserId(32));
		userEntity.setEncryptedPassword("password test user");
		
		UserEntity newUser= userRepository.save(userEntity);
		UserDto userDto = new UserDto();
		
		BeanUtils.copyProperties(newUser, userDto);
		
				
		return userDto;
	}

}
