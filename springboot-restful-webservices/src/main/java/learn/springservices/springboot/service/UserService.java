package learn.springservices.springboot.service;

import java.util.List;

import learn.springservices.springboot.dto.UserDto;
import learn.springservices.springboot.entity.User;

public interface UserService {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user);
	void deleteUser(Long id);
	UserDto getUser(Long id);
	List<UserDto> getAllUsers();
}
