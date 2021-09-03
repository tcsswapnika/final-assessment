package com.tcs.finalassessment.service;

import com.tcs.finalassessment.entity.QuestionEntity;

public interface IQuestionService {

	QuestionEntity saveQuestion(QuestionEntity question);

	Iterable<QuestionEntity> getAll();

	void deleteQuestion(Integer id);

	String updateAnswers(QuestionEntity question, Integer id);

	String upvote(QuestionEntity question, Integer id);

}
