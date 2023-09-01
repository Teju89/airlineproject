package com.jspiders.jams.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.jams.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUserNameAndPassword(String username, String password);
}
