package proj.service;

import org.springframework.transaction.annotation.Transactional;
import proj.dao.SchoolDao;
import proj.model.School;

import java.util.List;

public class SchoolServiceImp implements SchoolService {
    private SchoolDao schoolDao;

    public void setSchoolDao(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }


    @Override
    @Transactional
    public void addSchool(School school) {
        schoolDao.addSchool(school);

    }

    @Override
    @Transactional
    public void updateSchool(School school) {
        schoolDao.updateSchool(school);
    }

    @Override
    @Transactional
    public void removeSchool(int id) {
        schoolDao.removeSchool(id);
    }

    @Override
    @Transactional
    public School getSchoolById(int id) {
        return schoolDao.getSchoolById(id);
    }

    @Override
    @Transactional
    public List<School> listSchools() {
        return schoolDao.listSchools();
    }
}
