package proj.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.dao.SubjectDao;
import proj.model.Subject;

import java.util.List;

@Service
public class SubjectServiceImp implements SubjectService {
    private SubjectDao subjectDao;

    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    @Transactional
    public void addSubject(Subject subject) {
        subjectDao.addSubject(subject);
    }

    @Override
    @Transactional
    public void updateSubject(Subject subject) {
        subjectDao.updateSubject(subject);
    }

    @Override
    @Transactional
    public void removeSubject(int id) {
        subjectDao.removeSubject(id);

    }

    @Override
    @Transactional
    public Subject getSubjectById(int id) {
        return subjectDao.getSubjectById(id);
    }

    @Override
    @Transactional
    public List<Subject> listSubjects() {
        return subjectDao.listSubjects();
    }
}
