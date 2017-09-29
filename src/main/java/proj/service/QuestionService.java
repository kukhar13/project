package proj.service;

import proj.model.Question;

import java.util.List;

public interface QuestionService {
    void addQuestion(Question question);

    void updateQuestion(Question question);

    void removeQuestion(int id);

    Question getQuestionById(int id);

    List<Question> listQuestions();
}
