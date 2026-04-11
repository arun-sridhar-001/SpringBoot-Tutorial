package com.springboot.demo.service;

import com.springboot.demo.exception.StudentNotFoundException;
import com.springboot.demo.model.Student;
import com.springboot.demo.repositorty.StudentRepository;
import com.springboot.demo.response.StudentResponse;
import com.springboot.demo.response.SubjectResponse;
import com.springboot.demo.service.utils.StudentMapperUtils;
import com.springboot.demo.service.utils.SubjectMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class StudentManagementService {

    private final StudentMapperUtils studentMapperUtils;
    private final SubjectMapperUtils subjectMapperUtils;

    private final StudentRepository studentRepository;


    public String saveStudent(Student student) {
        Student studentModel = studentRepository.save(student);
        return studentModel.getName() + " has been added successfully";
    }

    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
//        Long count = studentRepository.getStudentCount("Madhan");
//        log.info("count is {}", count);
        return students.stream()
                .map(studentMapperUtils::mapToStudentResponse)
                .toList();
    }

    public StudentResponse findByStudentId(String id) throws StudentNotFoundException {
        Student student = studentRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

        List<SubjectResponse> subjectResponse = student.getSubjects().stream()
                .map(sub -> subjectMapperUtils.mapToSubjectResponse(sub))
                .collect(Collectors.toList());

        return studentMapperUtils.mapToStudentResponse(student, subjectResponse);
    }

    public StudentResponse updateStudent(String studentId, String mobileNumber) {
        log.info("Trying to update student mobileNumber with {}", mobileNumber);
        Student student = studentRepository.findById(UUID.fromString(studentId))
                .orElseThrow(
                        () -> new StudentNotFoundException("Student not found in our source with ID: " + studentId));

        student.setMobileNumber(mobileNumber);
        studentRepository.save(student);
        return studentMapperUtils.mapToStudentResponse(student);

    }

    public String deleteStudentById(String studentId) {
        try {
            studentRepository.deleteById(UUID.fromString(studentId));
        }
        catch (Exception e) {
            throw e;
        }
        return studentId + " Deleted Successfully!!";

    }

}
