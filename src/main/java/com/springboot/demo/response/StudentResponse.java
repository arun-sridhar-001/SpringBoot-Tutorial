package com.springboot.demo.response;

import com.springboot.demo.bean.Gender;
import com.springboot.demo.bean.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    private String id;
    private String name;
    private Integer age;
    private Gender gender;
    private String emailAddress;
    private String address;
    private String parentName;
    private StudentStatus status;

    private List<SubjectResponse> subjectResponse;
}
