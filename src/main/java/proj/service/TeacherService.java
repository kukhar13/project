package proj.service;

import proj.model.Teacher;

import java.util.List;

public interface TeacherService {
    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void removeTeacher(int id);

    Teacher getTeacherById(int id);

    List<Teacher> listTeachers();
}
