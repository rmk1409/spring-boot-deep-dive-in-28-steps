package com.veselov.alex.controller;

import com.veselov.alex.model.Question;
import com.veselov.alex.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SurveyController {
    @Autowired
    private SurveyService service;

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> getQuestions(@PathVariable String surveyId) {
        return this.service.retrieveQuestions(surveyId);
    }

    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question getQuestions(@PathVariable String surveyId, @PathVariable String questionId) {
        return this.service.retrieveQuestion(surveyId, questionId);
    }
}
