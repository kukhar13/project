package proj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import proj.model.Question;
import proj.model.Student;

import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(StudentDaoImp.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(student);
        LOGGER.info("student has added" + student);

    }

    @Override
    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);
        LOGGER.info("student has updated" + student);

    }

    @Override
    public void removeStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = (Student) session.load(Student.class, id);
        if (student != null) {
            session.delete(student);

        }
        LOGGER.info("student has removed" + student);

    }

    @Override
    public Student getStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = (Student) session.load(Student.class, id);
        LOGGER.info("student has loaded" + student);
        return student;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> listStudents() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> students = session.createQuery("from proj.model.Student").list();
        for (Student student : students) {
            LOGGER.info("Student list " + student);
        }
        return students;
    }
}
