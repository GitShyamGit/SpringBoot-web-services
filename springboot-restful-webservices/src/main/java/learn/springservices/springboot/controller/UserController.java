package learn.springservices.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import learn.springservices.springboot.dto.UserDto;
import learn.springservices.springboot.entity.User;
import learn.springservices.springboot.mapper.UserMapper;
import learn.springservices.springboot.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

	@Autowired
	private UserService userService;
	
	//build create User REST API
	
	//https://localhost:8080/api/user/create-user
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto user ){
		System.out.println(user);
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId ){
		System.out.println(userId);
		UserDto getuser = userService.getUser(userId);
		return new ResponseEntity<>(getuser,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getUserById(){
		List<UserDto> getuser = userService.getAllUsers();
		return new ResponseEntity<>(getuser,HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user){
		UserDto updatedUser = userService.updateUser(user);
		return new ResponseEntity<UserDto>(updatedUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("User Deleted Successfully!",HttpStatus.OK);
	}
}
