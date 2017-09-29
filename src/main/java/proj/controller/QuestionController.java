package proj.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proj.model.Question;
import proj.model.Subject;
import proj.service.QuestionService;
import proj.service.SubjectService;

import java.util.List;

@Controller
public class QuestionController {
    private QuestionService questionService;

    @Autowired
    @Qualifier(value = "questionService")
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "/question/add", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        if (question.getId() == 0) {
            questionService.addQuestion(question);
        } else {
            questionService.updateQuestion(question);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/question/", method = RequestMethod.PUT)
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        try {
            questionService.updateQuestion(question);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/question/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<Question> removeQuestion(@PathVariable("id") int id) {
        try {
            questionService.removeQuestion(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "question/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Question> getQuestionById(@PathVariable("id") int id) {
        Question question;
        try {
            question = questionService.getQuestionById(id);
            return new ResponseEntity<>(question, HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "question", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Question>> listQuestions() {
        List<Question> questionList = questionService.listQuestions();
        return new ResponseEntity<>(questionList, HttpStatus.OK);
    }
}

