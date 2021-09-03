package com.tcs.finalassessment.service;

import javax.validation.Valid;

import com.tcs.finalassessment.entity.UserEntity;

public interface IUserService {

	UserEntity saveUser(@Valid UserEntity user);

	Iterable<UserEntity> getAll();

	void deleteUser(Integer id);

	UserEntity updateUser(Integer id, UserEntity user);

	

}