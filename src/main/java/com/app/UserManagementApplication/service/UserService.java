package com.app.UserManagementApplication.service;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.app.UserManagementApplication.dto.UserRequestDTO;
import com.app.UserManagementApplication.dto.UserResponseDTO;
import com.app.UserManagementApplication.entity.User;
import com.app.UserManagementApplication.exception.UserNotFoundException;
import com.app.UserManagementApplication.repository.UserRepository;

@Service
public class UserService {

	UserRepository repository;
	ModelMapper mapper;

	public UserService(UserRepository repository, ModelMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	public UserResponseDTO registerUser(UserRequestDTO requestDto) {
		User user = mapper.map(requestDto, User.class);
		User savedUser = repository.save(user);
		return mapper.map(savedUser, UserResponseDTO.class);
	}
	
	public UserResponseDTO getUserById(int id) {
		User user = repository.findById(id).orElseThrow(()->new UserNotFoundException("User not found with id: "+id));
		return mapper.map(user, UserResponseDTO.class);
	}
	
	public List<UserResponseDTO> getAllUsers(){
		List<User> users= repository.findAll();
		return users.stream().map(user -> mapper.map(user, UserResponseDTO.class)).toList();
	}
	
	public UserResponseDTO updateUser(int id,UserRequestDTO requestDto) {
		User user = repository.findById(id).orElseThrow(()->new UserNotFoundException("User not found with id: "+id));
		user.setName(requestDto.getName());
	    user.setEmail(requestDto.getEmail());
	    user.setPhone(requestDto.getPhone());
	    user.setRole(requestDto.getRole());
	    
	    User savedUser = repository.save(user);
	    return mapper.map(savedUser, UserResponseDTO.class);
	}
	
	public void deleteUser(int id) {
		User user = repository.findById(id).orElseThrow(()->new UserNotFoundException("User not found with id: "+id));
	    repository.delete(user);
	}
	
	public UserResponseDTO updatePartialStudent(int id, Map<String, Object> updates) {
		User user = repository.findById(id).orElseThrow(()->new UserNotFoundException("User not found with id: "+id));
		
		updates.forEach((field, value)->{
			switch(field) {
			case "name": user.setName((String) value);
			break;
			case "email": user.setEmail((String) value);
			break;
			case "password": user.setPassword((String) value);
			break;
			case "phone": user.setPhone((String) value);
			break;
			case "role": user.setRole((String) value);
			break;
			}
		});
		
		User savedUser = repository.save(user);
		return mapper.map(savedUser, UserResponseDTO.class);
	}
}
