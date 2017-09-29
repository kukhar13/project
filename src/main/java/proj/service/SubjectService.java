package proj.service;

import proj.model.Subject;

import java.util.List;

public interface SubjectService {
    void addSubject(Subject subject);

    void updateSubject(Subject subject);

    void removeSubject(int id);

    Subject getSubjectById(int id);

    List<Subject> listSubjects();
}
