package com.example.demo_p.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.time.Month;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void  addNewStudent(Student student) {
        Optional<Student> studentOptional =studentRepository.findByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email already exist");
        }
         studentRepository.save(student);
    }



    public List<Student> getStudents() {
        return studentRepository.findAll();

    }
}
