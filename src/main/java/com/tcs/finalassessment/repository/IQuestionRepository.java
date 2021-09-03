package com.tcs.finalassessment.repository;

import org.springframework.data.repository.CrudRepository;

import com.tcs.finalassessment.entity.QuestionEntity;

public interface IQuestionRepository extends CrudRepository<QuestionEntity, Integer> {

}