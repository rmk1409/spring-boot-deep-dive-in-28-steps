package com.veselov.alex.controller;

import com.veselov.alex.model.Question;
import com.veselov.alex.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyController {
    @Autowired
    private SurveyService service;

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> getQuestions(@PathVariable String surveyId) {
        return this.service.retrieveQuestions(surveyId);
    }

    @PostMapping("/surveys/{surveyId}/questions")
    public ResponseEntity<Object> postQuestionToSurvey(@PathVariable String surveyId, @RequestBody Question question) {
        Question created = this.service.addQuestion(surveyId, question);
        if (created == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/surveys/{surveyId}/questions/{questionId}")
    public Question getQuestions(@PathVariable String surveyId, @PathVariable String questionId) {
        return this.service.retrieveQuestion(surveyId, questionId);
    }
}
