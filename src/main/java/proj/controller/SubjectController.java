package proj.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proj.model.Subject;
import proj.service.SubjectService;


import java.util.List;

@Controller
public class SubjectController {
    private SubjectService subjectService;

    @Autowired
    @Qualifier(value = "subjectService")
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping(value = "/subject/add", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
        if (subject.getId() == 0) {
            subjectService.addSubject(subject);
        } else {
            subjectService.updateSubject(subject);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/subject/", method = RequestMethod.PUT)
    public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject) {
        try {
            subjectService.updateSubject(subject);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/subject/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<Subject> removeSubject(@PathVariable("id") int id) {
        try {
            subjectService.removeSubject(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "subject/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Subject> getSubjectById(@PathVariable("id") int id) {
        Subject subject;
        try {
            subject = subjectService.getSubjectById(id);
            return new ResponseEntity<>(subject, HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "subject", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Subject>> listSubjects() {
        List<Subject> subjectList = subjectService.listSubjects();
        return new ResponseEntity<>(subjectList, HttpStatus.OK);
    }
}



