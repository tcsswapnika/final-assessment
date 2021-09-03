package com.tcs.finalassessment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tcs.finalassessment.entity.UserEntity;
import com.tcs.finalassessment.exception.UserNotFoundException;
import com.tcs.finalassessment.repository.IUserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	IUserRepository userRepository;

	@Override
	public UserEntity saveUser(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public Iterable<UserEntity> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Integer id) {
		Optional<UserEntity> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		userRepository.deleteById(id);

	}

	@Override
	public UserEntity updateUser(Integer id, UserEntity user1) {
		Optional<UserEntity> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		UserEntity us = user.get();
		if (StringUtils.hasText(user1.getName())) {
			us.setName(user1.getName());
		}
		return userRepository.save(us);
	}
}
