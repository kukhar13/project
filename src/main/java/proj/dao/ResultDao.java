package proj.dao;


import proj.model.Result;

import java.util.List;

public interface ResultDao  {
    void addResult(Result result);

    void updateResult(Result result);

    void removeResult(int id);

    Result getResultById(int id);

    List<Result> listResults();
}
