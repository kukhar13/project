package proj.controller;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import proj.model.School;
import proj.model.Student;
import proj.model.Subject;
import proj.service.StudentService;
import proj.service.SubjectService;

import java.util.List;
@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    @Qualifier(value = "studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/student/add", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Student> addStudent(@RequestBody Student student) {

        if (student.getId() == 0) {
            studentService.addStudent(student);
        } else {
            studentService.updateStudent(student);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/student/", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        try {
            studentService.updateStudent(student);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<Student> removeStudent(@PathVariable("id") int id) {
        try {
            studentService.removeStudent(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "student/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
        Student student;
        try {
            student = studentService.getStudentById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (ObjectNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "student", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List<Student>> listStudents() {
        List<Student> studentList = studentService.listStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}

