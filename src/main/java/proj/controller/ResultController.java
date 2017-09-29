package proj.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proj.model.Result;
import proj.model.Subject;
import proj.service.ResultService;
import proj.service.SubjectService;

import java.util.List;
@Controller
public class ResultController {
    private ResultService resultService;

    @Autowired
    @Qualifier(value = "resultService")
    public void setSubjectService(ResultService resultService) {
        this.resultService = resultService;
    }

    @RequestMapping(value = "/result/add", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Result> addResult(@RequestBody Result result) {
        if (result.getId() == 0) {
            resultService.addResult(result);
        } else {
            resultService.updateResult(result);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/result/", method = RequestMethod.PUT)
    public ResponseEntity<Result> updateResult(@RequestBody Result result) {
        try {
            resultService.updateResult(result);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/result/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<Result> removeResult(@PathVariable("id") int id) {
        try {
            resultService.removeResult(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "result/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Result> getResultById(@PathVariable("id") int id) {
        Result result;
        try {
            result = resultService.getResultById(id);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "result", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Result>> listResults() {
        List<Result> resultList = resultService.listResults();
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }
}

