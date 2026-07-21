package com.korea.todo.service;

import org.springframework.stereotype.Service;

import com.korea.todo.entity.UserEntity;
import com.korea.todo.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository repository;
	
	// 회원가입 기능
	public UserEntity create(UserEntity user) {
		if(user == null || user.getUsername() == null) {
			throw new RuntimeException("Invald arguments");
		}
		
		final String username = user.getUsername();
		
		if(repository.existsByUsername(username)) {
			log.warn("Username already exists {}",username);
			throw new RuntimeException("Username already exists");
		}
		
		UserEntity savedUser = repository.save(user);
		log.info("Entity Id: {} is saved",savedUser.getId());
		
		return savedUser;
	}
	
	// 로그인 기능
	public UserEntity getByCredentials(String username, String password) {
		return repository.findByUsernameAndPassword(username, password);
	}
	
	
	
}