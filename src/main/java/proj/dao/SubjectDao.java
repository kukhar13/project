package proj.dao;

import proj.model.Subject;

import java.util.List;

public interface SubjectDao {
    void addSubject(Subject subject);

    void updateSubject(Subject subject);

    void removeSubject(int id);

    Subject getSubjectById(int id);

    List<Subject> listSubjects();
}
