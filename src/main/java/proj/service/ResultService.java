package proj.service;

import proj.model.Result;

import java.util.List;

public interface ResultService {
    void addResult(Result result);

    void updateResult(Result result);

    void removeResult(int id);

    Result getResultById(int id);

    List<Result> listResults();
}
