package com.springboot.demo.service.utils;

import com.springboot.demo.model.Student;
import com.springboot.demo.model.Subject;
import com.springboot.demo.response.StudentResponse;
import com.springboot.demo.response.SubjectResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentMapperUtils {

    public StudentResponse mapToStudentResponse(Student student) {

        return StudentResponse.builder()
                .id(student.getId().toString())
                .name(student.getName())
                .age(student.getAge())
                .emailAddress(student.getEmailAddress())
                .gender(student.getGender())
                .address(student.getAddress())
                .status(student.getStatus())
                .parentName(student.getParentName())
                .build();

//        StudentResponse studentResponse = new StudentResponse();
//
//        studentResponse.setId(student.getId());
//        studentResponse.setName(student.getName());
//        studentResponse.setAge(student.getAge());
//        studentResponse.setEmailAddress(student.getEmailAddress());
//        studentResponse.setGender(student.getGender());
//        studentResponse.setAddress(student.getAddress());
//        studentResponse.setStatus(student.getStatus());
//        studentResponse.setParentName(student.getParentName());

    }


    public StudentResponse mapToStudentResponse(Student student, List<SubjectResponse> subjectResponse) {

        return StudentResponse.builder()
                .id(student.getId().toString())
                .name(student.getName())
                .age(student.getAge())
                .emailAddress(student.getEmailAddress())
                .gender(student.getGender())
                .address(student.getAddress())
                .status(student.getStatus())
                .parentName(student.getParentName())
                .subjectResponse(subjectResponse)
                .build();

    }
}
