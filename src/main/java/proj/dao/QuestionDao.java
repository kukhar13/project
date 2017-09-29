package proj.dao;

import proj.model.Question;
import proj.model.School;

import java.util.List;

public interface QuestionDao  {
    void addQuestion(Question question);

    void updateQuestion(Question question);

    void removeQuestion(int id);

    Question getQuestionById(int id);

    List<Question> listQuestions();
}
