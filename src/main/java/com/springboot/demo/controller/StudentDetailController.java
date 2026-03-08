package com.springboot.demo.controller;

import com.springboot.demo.exception.StudentNotFoundException;
import com.springboot.demo.model.Student;
import com.springboot.demo.response.StudentResponse;
import com.springboot.demo.service.StudentManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-management")
@RequiredArgsConstructor
public class StudentDetailController {

    private final StudentManagementService studentManagementService;

    @GetMapping("/test")
    public String apiTesting() {
        return "API working as Expected!!!";
    }

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student student) {
        return studentManagementService.saveStudent(student);
    }


    @GetMapping("/all")
    public List<StudentResponse> findAllStudents() {
        return studentManagementService.getAllStudents();
    }


    @GetMapping("/{id}")
    public StudentResponse findById(@PathVariable("id") String id) throws StudentNotFoundException {
        return studentManagementService.findByStudentId(id);
    }

    @PutMapping("/update")
    public StudentResponse updateStudent(@RequestParam(name = "studentId", required = true) String studentId,
                                         @RequestParam(name = "mobileNumber", required = true) String mobileNumber) {  //  mobileNumber -> request to update
        return studentManagementService.updateStudent(studentId, mobileNumber);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable("id") String id) {
        return studentManagementService.deleteStudentById(id);
    }
}
