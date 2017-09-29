package proj.dao;

import proj.model.School;
import proj.model.Subject;

import java.util.List;

public interface SchoolDao {
    void addSchool(School school);

    void updateSchool(School school);

    void removeSchool(int id);

    School getSchoolById(int id);

    List<School> listSchools();
}
