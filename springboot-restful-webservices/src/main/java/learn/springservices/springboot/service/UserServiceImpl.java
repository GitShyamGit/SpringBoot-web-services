package learn.springservices.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learn.springservices.springboot.dto.UserDto;
import learn.springservices.springboot.entity.User;
import learn.springservices.springboot.mapper.UserMapper;
import learn.springservices.springboot.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		//User user = UserMapper.mapToUser(userDto);
		User user = modelMapper.map(userDto, User.class);
		return modelMapper.map(userRepository.save(user),UserDto.class);
	}

	@Override 
	public UserDto getUser(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		User user = optionalUser.get();
		return modelMapper.map(user,UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> userList= userRepository.findAll();
		List<UserDto> userDto  = userList.stream().map((u)->modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public UserDto updateUser(UserDto user) {
		User existingUser =userRepository.findById(user.getId()).get();
		existingUser.setEmail(user.getEmail());
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		UserDto updatedUser = modelMapper.map(userRepository.save(existingUser),UserDto.class);
		return updatedUser;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

}
