package proj.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.dao.QuestionDao;
import proj.model.Question;

import java.util.List;

@Service
public class QuestionServiceImp implements QuestionService {
    private QuestionDao questionDao;

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    @Transactional
    public void addQuestion(Question question) {
        questionDao.addQuestion(question);

    }

    @Override
    @Transactional
    public void updateQuestion(Question question) {
        questionDao.updateQuestion(question);

    }

    @Override
    @Transactional
    public void removeQuestion(int id) {
        questionDao.removeQuestion(id);

    }

    @Override
    @Transactional
    public Question getQuestionById(int id) {
        return questionDao.getQuestionById(id);
    }

    @Override
    @Transactional
    public List<Question> listQuestions() {
        return questionDao.listQuestions();
    }
}
