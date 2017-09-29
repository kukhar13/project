package proj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import proj.model.Subject;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class SubjectDaoImp implements SubjectDao {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SubjectDaoImp.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSubject(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(subject);
        LOGGER.info("subject has added" + subject);
    }

    @Override
    public void updateSubject(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        session.update(subject);
        LOGGER.info("subject has updated" + subject);

    }

    @Override
    public void removeSubject(int id) {
        Session session = sessionFactory.getCurrentSession();
        Subject subject = (Subject) session.load(Subject.class, id);
        if (subject != null) {
            session.delete(subject);

        }
        LOGGER.info("subject has removed" + subject);

    }

    @Override
    public Subject getSubjectById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Subject subject = (Subject) session.load(Subject.class, id);
        LOGGER.info("subject has loaded" + subject);
        return subject;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Subject> listSubjects() {
        Session session = sessionFactory.getCurrentSession();
        List<Subject> subjects = session.createQuery("from proj.model.Subject").list();
        for (Subject subject : subjects) {
            LOGGER.info("Subject list " + subject);
        }

        return subjects;
    }
}
