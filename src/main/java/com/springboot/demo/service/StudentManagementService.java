package com.springboot.demo.service;

import com.springboot.demo.exception.StudentNotFoundException;
import com.springboot.demo.model.Student;
import com.springboot.demo.response.StudentResponse;
import com.springboot.demo.service.utils.StudentMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Slf4j
public class StudentManagementService {

    private final StudentMapperUtils studentMapperUtils;

//    Logger log = LoggerFactory.getLogger(StudentManagementService.class);


    List<Student> studentList = new ArrayList<>();

    public String saveStudent(Student student) {
        student.setId(UUID.randomUUID().toString());
        studentList.add(student);
        return student.getName() + " has been added successfully";
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public Student findByStudentId(String id) throws StudentNotFoundException {
        return studentList.stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst().orElseThrow(
                        () -> new StudentNotFoundException("Student not found in our source with ID: " + id)
                );
    }

    public StudentResponse updateStudent(String studentId, String mobileNumber) {
        log.info("Trying to update student mobileNumber with {}", mobileNumber);
        Student student = studentList.stream()
                .filter(s -> studentId.equals(s.getId()))
                .findFirst().orElseThrow(
                        () -> new StudentNotFoundException("Student not found in our source with ID: " + studentId)
                );


        student.setMobileNumber(mobileNumber);

        return studentMapperUtils.mapToStudentResponse(student);

    }

    //ToDo findByName method

}
