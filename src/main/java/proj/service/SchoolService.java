package proj.service;

import proj.model.School;

import java.util.List;

public interface SchoolService {
    void addSchool(School school);

    void updateSchool(School school);

    void removeSchool(int id);

    School getSchoolById(int id);

    List<School> listSchools();
}
