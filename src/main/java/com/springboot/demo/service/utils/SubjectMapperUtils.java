package com.springboot.demo.service.utils;


import com.springboot.demo.model.Subject;
import com.springboot.demo.request.SubjectRequest;
import com.springboot.demo.response.SubjectResponse;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapperUtils {

    public Subject mapToSubject(SubjectRequest subjectRequest) {
        return Subject.builder()
                .subjectName(subjectRequest.getSubjectName())
                .build();
    }

    public SubjectResponse mapToSubjectResponse(Subject subject) {
        return SubjectResponse.builder()
                .subjectId(subject.getId().toString())
                .subjectName(subject.getSubjectName())
                .build();
    }

}
