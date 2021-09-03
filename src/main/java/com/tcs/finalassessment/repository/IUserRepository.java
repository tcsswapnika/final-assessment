package com.tcs.finalassessment.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.finalassessment.entity.UserEntity;

public interface IUserRepository extends CrudRepository<UserEntity, Integer> {

}