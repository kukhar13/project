package proj.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.dao.StudentDao;
import proj.model.Student;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        studentDao.addStudent(student);

    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);


    }

    @Override
    @Transactional
    public void removeStudent(int id) {
        studentDao.removeStudent(id);
    }

    @Override
    @Transactional
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    @Transactional
    public List<Student> listStudents() {
        return studentDao.listStudents();
    }
}
