package proj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import proj.model.School;

import java.util.List;

public class SchoolDaoImp implements SchoolDao {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SchoolDaoImp.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addSchool(School school) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(school);
        LOGGER.info("school has added" + school);
    }

    @Override
    public void updateSchool(School school) {
        Session session = sessionFactory.getCurrentSession();
        session.update(school);
        LOGGER.info("school has updated" + school);
    }

    @Override
    public void removeSchool(int id) {
        Session session = sessionFactory.getCurrentSession();
        School school = (School) session.load(School.class, id);
        if (school != null) {
            session.delete(school);

        }
        LOGGER.info("school has removed" + school);

    }

    @Override
    public School getSchoolById(int id) {
        Session session = sessionFactory.getCurrentSession();
        School school = (School) session.load(School.class, id);
        LOGGER.info("school has loaded" + school);
        return school;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<School> listSchools() {
        Session session = sessionFactory.getCurrentSession();
        List<School> schools = session.createQuery("from proj.model.School").list();
        for (School school : schools) {
            LOGGER.info("SchoolController list " + school);
        }

        return schools;
    }
}
