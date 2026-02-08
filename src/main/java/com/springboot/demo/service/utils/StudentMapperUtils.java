package com.springboot.demo.service.utils;

import com.springboot.demo.model.Student;
import com.springboot.demo.response.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperUtils {

    public StudentResponse mapToStudentResponse(Student student) {
        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setId(student.getId());
        studentResponse.setName(student.getName());
        studentResponse.setAge(student.getAge());
        studentResponse.setEmailAddress(student.getEmailAddress());
        studentResponse.setGender(student.getGender());
        studentResponse.setAddress(student.getAddress());
        studentResponse.setStatus(student.getStatus());
        studentResponse.setParentName(student.getParentName());

        return studentResponse;

    }
}
