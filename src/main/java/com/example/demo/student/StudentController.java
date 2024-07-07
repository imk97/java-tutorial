package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        this.studentService.findStudent(student);
    }

    @PutMapping(path = "{putStudent}")
    public void updateStudent(@PathVariable("putStudent") Long id, @RequestParam(name = "name") String name, @RequestParam(name = "email") String email) {
        this.studentService.updateStudent(id, name, email);
    }

    @DeleteMapping(path = "{delStudent}")
    public void deleteStudent(@PathVariable("delStudent") Long id) {
        this.studentService.deleteStudent(id);
    }


}
