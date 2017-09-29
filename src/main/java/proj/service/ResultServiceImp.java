package proj.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.dao.ResultDao;
import proj.model.Result;

import java.util.List;

@Service
public class ResultServiceImp implements ResultService {
    private ResultDao resultDao;

    public void setResultDao(ResultDao resultDao) {
        this.resultDao = resultDao;
    }

    @Override
    @Transactional
    public void addResult(Result result) {
        resultDao.addResult(result);

    }

    @Override
    @Transactional
    public void updateResult(Result result) {
       resultDao.updateResult(result);

    }

    @Override
    @Transactional
    public void removeResult(int id) {
        resultDao.removeResult(id);

    }

    @Override
    @Transactional
    public Result getResultById(int id) {
        return resultDao.getResultById(id);
    }

    @Override
    public List<Result> listResults() {
        return resultDao.listResults();
    }
}
