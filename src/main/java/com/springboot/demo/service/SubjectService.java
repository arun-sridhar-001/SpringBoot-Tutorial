package com.springboot.demo.service;


import com.springboot.demo.model.Student;
import com.springboot.demo.model.Subject;
import com.springboot.demo.repositorty.StudentRepository;
import com.springboot.demo.repositorty.SubjectRepository;
import com.springboot.demo.request.SubjectRequest;
import com.springboot.demo.service.utils.SubjectMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectService {

    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;

    private final SubjectMapperUtils subjectMapperUtils;

    public String saveSubjects(List<SubjectRequest> subjectRequest, String studentId) {
        UUID id = UUID.fromString(studentId);
        Optional<Student> student = studentRepository.findById(id);
        Optional<Student> studentName = studentRepository.findByName(student.get().getName());
//        log.info(studentName.get().getName());
        List<Subject> subjectList = new ArrayList<>();
        if(student.isPresent()) {
            for(SubjectRequest sub : subjectRequest) {
                Subject subject = subjectMapperUtils.mapToSubject(sub);
                subject.setStudent(student.get());
                subjectList.add(subject);
            }
            subjectRepository.saveAll(subjectList);

            return "Subjects saved for student ID : "+ studentId;
        }

        return "No Students found!";

    }

}
