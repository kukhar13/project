package proj.controller;



import org.hibernate.ObjectNotFoundException;
import org.hibernate.annotations.MetaValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import proj.model.School;


import proj.service.SchoolService;


import java.io.Serializable;
import java.util.List;


@Controller
public class SchoolController {
    private SchoolService schoolService;

    @Autowired
    @Qualifier(value = "schoolService")
    public void setSchoolService(SchoolService schoolService) {
        this.schoolService = schoolService;

    }

    @RequestMapping(value = "/school/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<School> addSchool(@RequestBody  School  school ) {
//        School school1 = new School();
//        school1.setName("sad");
//        schoolService.addSchool(school1);
        if (school.getId() == 0) {
            schoolService.addSchool(school);
        } else {
            schoolService.updateSchool(school);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/school/", method = RequestMethod.PUT)
    public ResponseEntity<School> updateSchool(@RequestBody  School school) {
        try {
            schoolService.updateSchool(school);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/school/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<School> removeSchool(@PathVariable("id") int id) {
        try {
            schoolService.removeSchool(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "school/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<School> getSchoolById(@PathVariable("id") int id) {
        School school;
        try {
            school = schoolService.getSchoolById(id);
            return new ResponseEntity<>(school, HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "school", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<School>> listSchools() {
        List<School> schoolList = schoolService.listSchools();
        return new ResponseEntity<>(schoolList, HttpStatus.OK);
    }
}
