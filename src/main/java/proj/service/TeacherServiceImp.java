package proj.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.dao.TeacherDao;
import proj.model.Teacher;

import java.util.List;
@Service
public class TeacherServiceImp implements TeacherService {
    private TeacherDao teacherDao;

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    @Transactional
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    @Override
    @Transactional
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);

    }

    @Override
    @Transactional
    public void removeTeacher(int id) {
        teacherDao.removeTeacher(id);

    }

    @Override
    @Transactional
    public Teacher getTeacherById(int id) {
        return teacherDao.getTeacherById(id);
    }

    @Override
    public List<Teacher> listTeachers() {
        return teacherDao.listTeachers();
    }
}
