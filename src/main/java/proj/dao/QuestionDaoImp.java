package proj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import proj.model.Question;
import proj.model.Subject;

import java.util.List;

@Repository
public class QuestionDaoImp implements QuestionDao {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(QuestionDaoImp.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public void addQuestion(Question question) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(question);
        LOGGER.info("question has added" + question);

    }

    @Override
    public void updateQuestion(Question question) {
        Session session = sessionFactory.getCurrentSession();
        session.update(question);
        LOGGER.info("question has updated" + question);
    }

    @Override
    public void removeQuestion(int id) {
        Session session = sessionFactory.getCurrentSession();
        Question question = (Question) session.load(Question.class, id);
        if (question != null) {
            session.delete(question);

        }
        LOGGER.info("question has removed" + question);

    }

    @Override
    public Question getQuestionById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Question question = (Question) session.load(Question.class, id);
        LOGGER.info("question has loaded" + question);
        return question;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Question> listQuestions() {
        Session session = sessionFactory.getCurrentSession();
        List<Question> questions = session.createQuery("from proj.model.Question").list();
        for (Question question : questions) {
            LOGGER.info("Question list " + question);
        }

        return questions;
    }
}
