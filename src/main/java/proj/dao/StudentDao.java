package proj.dao;

import proj.model.Question;
import proj.model.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);

    void updateStudent(Student student);

    void removeStudent(int id);

    Student getStudentById(int id);

    List<Student> listStudents();
}
