package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

//    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
//    @Autowired
//    StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void findStudent(Student student) {
        Optional<Student> studentByEmail = this.studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        this.studentRepository.save(student);
//        System.out.println(student);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {

        // Dia jumpa data then simpan di student class
        Student student = this.studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist"));


        // Data yang dijumpa then ubah data tersebut
//        new Student(name, email);
        student.setName(name);
        student.setEmail(email);
//        Student student1 = new Student(name, email, student.getDob());
        this.studentRepository.save(student);

    }

    public void deleteStudent(Long id) {
        Boolean studentExist = this.studentRepository.existsById(id);
        if (!studentExist) {
            throw new IllegalStateException("student with id " + id + " does not exist");
        }
        this.studentRepository.deleteById(id);
    }
}
