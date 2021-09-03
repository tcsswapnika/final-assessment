package com.tcs.finalassessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.finalassessment.entity.QuestionEntity;
import com.tcs.finalassessment.service.IQuestionService;

public class QuestionController {
	@Autowired
	IQuestionService questionService;

	@PostMapping
	public QuestionEntity createQuestion(@RequestBody QuestionEntity ques) {
		return questionService.saveQuestion(ques);
	}

	@GetMapping
	public Iterable<QuestionEntity> getAllQuestion() {
		return questionService.getAll();
	}

	@DeleteMapping("/question/{id}")
	public void deleteQuestion(@PathVariable Integer id) {
		questionService.deleteQuestion(id);
	}

	@PutMapping("/answer/{id}")
	public String addAnswer(@RequestBody QuestionEntity question, @PathVariable Integer id) {
		return questionService.updateAnswers(question, id);
	}

	@PutMapping("/increment/{id}")
	public String upvote(@RequestBody QuestionEntity question, @PathVariable Integer id) {
		return questionService.upvote(question, id);
	}

}
