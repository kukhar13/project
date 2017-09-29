package proj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import proj.model.Subject;
import proj.model.Teacher;

import java.util.List;
@Repository
public class TeacherDaoImp implements TeacherDao {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TeacherDaoImp.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(teacher);
        LOGGER.info("teacher has added" + teacher);

    }

    @Override
    public void updateTeacher(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.update(teacher);
        LOGGER.info("teacher has updated" + teacher);

    }

    @Override
    public void removeTeacher(int id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = (Teacher) session.load(Teacher.class, id);
        if (teacher != null) {
            session.delete(teacher);

        }
        LOGGER.info("teacher has removed" + teacher);

    }

    @Override
    public Teacher getTeacherById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = (Teacher) session.load(Teacher.class, id);
        LOGGER.info("teacher has loaded" + teacher);
        return teacher;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Teacher> listTeachers() {
        Session session = sessionFactory.getCurrentSession();
        List<Teacher> teachers = session.createQuery("from proj.model.Teacher").list();
        for (Teacher teacher : teachers) {
            LOGGER.info("Teacher list " + teacher);
        }

        return teachers;
    }
}
