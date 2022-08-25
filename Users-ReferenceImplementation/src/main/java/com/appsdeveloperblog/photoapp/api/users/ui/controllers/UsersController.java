package com.appsdeveloperblog.photoapp.api.users.ui.controllers;

import com.appsdeveloperblog.photoapp.api.users.service.UsersService;
import com.appsdeveloperblog.photoapp.api.users.shared.UserDto;
import com.appsdeveloperblog.photoapp.api.users.ui.model.CreateUserRequestModel;
import com.appsdeveloperblog.photoapp.api.users.ui.model.CreateUserResponseModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private Environment env;

	@Autowired
	UsersService usersService;


	@GetMapping("/status/check")
	public String status()
	{
		return "Working on port " + env.getProperty("local.server.port");
	}


	@PostMapping("/working")
	public ResponseEntity createUserWorking(@Valid @RequestBody CreateUserRequestModel userDetails)
	{
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = modelMapper.map(userDetails, UserDto.class);

		UserDto createdUser = usersService.createUser(userDto);

		return new ResponseEntity(HttpStatus.CREATED);
	}

	@PostMapping("/enhance")
	public ResponseEntity<CreateUserResponseModel> createUserEnhance(@Valid @RequestBody CreateUserRequestModel userDetails)
	{
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto userDto = modelMapper.map(userDetails, UserDto.class);

		UserDto createdUser = usersService.createUser(userDto);

		CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}

	/*@PostMapping
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails)
	{
		ModelMapper modelMapper = new ModelMapper();
		System.out.println("------------11-----------");
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		System.out.println("------------22-----------");
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);

		System.out.println("------------33-----------");
		UserDto createdUser = usersService.createUser(userDto);

		System.out.println("------------44-----------");
		CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);

		System.out.println("------------55-----------");
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}*/
}
