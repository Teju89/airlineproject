package com.jspiders.jams.service;

import com.jspiders.jams.dto.UserDTO;

public interface UserService {

	long register(UserDTO user);

	UserDTO login(String username, String password);
}
