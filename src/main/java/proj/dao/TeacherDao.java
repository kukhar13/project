package proj.dao;

import proj.model.Subject;
import proj.model.Teacher;

import java.util.List;

public interface TeacherDao  {
    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void removeTeacher(int id);

    Teacher getTeacherById(int id);

    List<Teacher> listTeachers();
}
