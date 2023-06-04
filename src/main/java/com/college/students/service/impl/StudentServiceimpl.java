package com.college.students.service.impl;

import com.college.students.entity.Student;
import com.college.students.exception.StudentNotFoundException;
import com.college.students.repository.StudentRepo;
import com.college.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    private StudentRepo StudentRepo;

    @Override
    public Student addStudent(Student student){
        return StudentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return StudentRepo.findAll();
    }

    @Override
    public Student getStudent(long id) throws StudentNotFoundException {
        try{
            return StudentRepo.findById(id).get();
        } catch (Exception e) {
            throw new StudentNotFoundException("Student Not Found with id: "+id);
        }
    }

    @Override
    public Student updateStudent(long id, Student student) {
        return StudentRepo.save(student);
    }

    @Override
    public void deleteStudent(long id) throws StudentNotFoundException{
        try{
            StudentRepo.deleteById(id);
        } catch (Exception e){
            throw new StudentNotFoundException("Student Not Found with id: "+id);
        }
    }
}
