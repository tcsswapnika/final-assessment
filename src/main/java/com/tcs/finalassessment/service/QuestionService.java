package com.tcs.finalassessment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tcs.finalassessment.entity.QuestionEntity;
import com.tcs.finalassessment.exception.UserNotFoundException;
import com.tcs.finalassessment.repository.IQuestionRepository;

public class QuestionService implements IQuestionService {
	@Autowired
	IQuestionRepository questionRepository;

	@Override
	public QuestionEntity saveQuestion(QuestionEntity question) {
		return questionRepository.save(question);
	}

	@Override
	public Iterable<QuestionEntity> getAll() {
		return questionRepository.findAll();
	}

	@Override
	public void deleteQuestion(Integer id) {
		Optional<QuestionEntity> question = questionRepository.findById(id);
		if (!question.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		questionRepository.deleteById(id);
	}

	@Override
	public String updateAnswers(QuestionEntity question, Integer id) {
		Optional<QuestionEntity> question1 = questionRepository.findById(id);
		if (!question1.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		List<String> ans = question.getAnswers();
		question1.get().setAnswers(ans);
		return "added new answer";
	}

	@Override
	public String upvote(QuestionEntity question, Integer id) {
		Optional<QuestionEntity> question1 = questionRepository.findById(id);
		if (!question1.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		int vote = question1.get().getVote();
		question1.get().setVote(vote + 1);
		return null;
	}

	public String downvote(QuestionEntity question, Integer id) {
		Optional<QuestionEntity> question1 = questionRepository.findById(id);
		if (!question1.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		int vote = question1.get().getVote();
		question1.get().setVote(vote - 1);
		return null;
	}

}
