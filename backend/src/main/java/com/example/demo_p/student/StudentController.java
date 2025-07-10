package com.example.demo_p.student;

import jakarta.persistence.NamedEntityGraphs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
@CrossOrigin(origins = "*")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }


    @PostMapping
    public ResponseEntity<String> registerNewStudent(@RequestBody Student student){
        try{
            studentService.addNewStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body("Student added successfully");

        }catch (DataIntegrityViolationException e){
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Its not you its us, " +
                    "we are trying to resolve the problem.");
        }

    }
//    @DeleteMapping(path="{studentId}")
//    public void deleteStudent(@PathVariable("studentId") Long studentId){
//         studentService.deleteStudent( studentId);
//    }
    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Long studentId) {
    try {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student with ID " + studentId + " has been deleted.");
    } catch (IllegalStateException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}

}
