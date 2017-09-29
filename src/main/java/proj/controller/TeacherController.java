package proj.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proj.model.Teacher;
import proj.service.TeacherService;

import java.util.List;

@Controller

public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    @Qualifier(value = "teacherService")
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        if (teacher.getId() == 0) {
            teacherService.addTeacher(teacher);
        } else {
            teacherService.updateTeacher(teacher);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/teacher/", method = RequestMethod.PUT)
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
        try {
            teacherService.updateTeacher(teacher);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<Teacher> removeTeacher(@PathVariable("id") int id) {
        try {
            teacherService.removeTeacher(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "teacher/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Teacher> getTeacherById(@PathVariable("id") int id) {
        Teacher teacher;
        try {
            teacher = teacherService.getTeacherById(id);
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "teacher", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Teacher>> listTeachers() {
        List<Teacher> teacherList = teacherService.listTeachers();
        return new ResponseEntity<>(teacherList, HttpStatus.OK);
    }
}