package com.college.students.service;

import com.college.students.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);
    List<Student> getAllStudent();


    Student getStudent(long id);

    Student updateStudent(long id,Student student);

    void deleteStudent(long id);
}
