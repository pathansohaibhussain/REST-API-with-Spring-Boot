package com.app.UserManagementApplication.controller;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.UserManagementApplication.dto.UserRequestDTO;
import com.app.UserManagementApplication.dto.UserResponseDTO;
import com.app.UserManagementApplication.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	UserService service;
	ModelMapper mapper;
	
	
	public UserController(UserService service, ModelMapper mapper) {
		super();
		this.service = service;
		this.mapper = mapper;
	}

	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRequestDTO requestDto){
		UserResponseDTO responseDTO = service.registerUser(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponseDTO> getUserById(@PathVariable int id){
		UserResponseDTO responseDTO = service.getUserById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(responseDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
		List<UserResponseDTO> userResponseDTOs = service.getAllUsers();
		return ResponseEntity.ok(userResponseDTOs);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserResponseDTO> updateUser(@PathVariable int id,@Valid @RequestBody UserRequestDTO requestDto){
		UserResponseDTO updatedUser = service.updateUser(id,requestDto);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		service.deleteUser(id);
		return ResponseEntity.ok("User with id {"+id+"} Deleted");
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<UserResponseDTO> updatePartialUser(@PathVariable int id,@Valid @RequestBody Map<String, Object> updates){
		UserResponseDTO updatedUser = service.updatePartialStudent(id, updates);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);
	}
}

