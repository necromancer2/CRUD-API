package com.college.students.controller;

import com.college.students.entity.Student;
import com.college.students.exception.StudentNotFoundException;
import com.college.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.college.students.repository.StudentRepo;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student){
        Student student1 = this.studentService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @GetMapping(value = "/fetchAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> student = this.studentService.getAllStudent();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) throws StudentNotFoundException {
        Student student = this.studentService.getStudent(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student student){
        Student updateStudent = this.studentService.updateStudent(id,student);
        return new ResponseEntity<>(updateStudent,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) throws StudentNotFoundException{
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }
}
