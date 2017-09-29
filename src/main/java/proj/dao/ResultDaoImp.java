package proj.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import proj.model.Result;

import java.util.List;

@Repository
public class ResultDaoImp implements ResultDao {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ResultDaoImp.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addResult(Result result) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(result);
        LOGGER.info("result has added" + result);

    }

    @Override
    public void updateResult(Result result) {
        Session session = sessionFactory.getCurrentSession();
        session.update(result);
        LOGGER.info("result has updated" + result);
    }

    @Override
    public void removeResult(int id) {
        Session session = sessionFactory.getCurrentSession();
        Result result = (Result) session.load(Result.class, id);
        if (result != null) {
            session.delete(result);

        }
        LOGGER.info("result has removed" + result);

    }

    @Override
    public Result getResultById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Result result = (Result) session.load(Result.class, id);
        LOGGER.info("result has loaded" + result);
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Result> listResults() {
        Session session = sessionFactory.getCurrentSession();
        List<Result> results = session.createQuery("from proj.model.Result").list();
        for (Result result : results) {
            LOGGER.info("Result list " + result);
        }
        return results;
    }
}
