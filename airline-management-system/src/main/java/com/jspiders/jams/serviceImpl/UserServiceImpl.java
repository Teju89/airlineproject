package com.jspiders.jams.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.jspiders.jams.dto.UserDTO;
import com.jspiders.jams.entity.User;
import com.jspiders.jams.repository.UserRepository;
import com.jspiders.jams.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	public long register(UserDTO user) {
		User user2 = new User();
		BeanUtils.copyProperties(user, user2);
		return userRepository.save(user2).getId();
	}

	@Override
	public UserDTO login(String username, String password) {
		Optional<User> userDB = userRepository.findByUserNameAndPassword(username, password);
		UserDTO user = new UserDTO();
		if (userDB.isPresent()) {
			BeanUtils.copyProperties(userDB.get(), user);
			return user;
		}
		return null;
	}

}
