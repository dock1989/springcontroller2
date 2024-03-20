package com.example.demo.dao;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class StudentDao {

    @Autowired
    StudentRepo studentRepo;

    public List<Student> getStudentData(){
        return studentRepo.findAll();
    }
}
