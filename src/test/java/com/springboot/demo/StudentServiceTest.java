package com.springboot.demo;


import com.springboot.demo.model.Student;
import com.springboot.demo.repositorty.StudentRepository;
import com.springboot.demo.response.StudentResponse;
import com.springboot.demo.service.StudentManagementService;
import com.springboot.demo.service.utils.StudentMapperUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentManagementService studentManagementService;

    @Mock
    StudentMapperUtils studentMapperUtils;



    @Test()
    void test_WhetherItCanSaveStudent() {
        Student student = Student.builder()
                .name("Arun")
                .id(UUID.randomUUID())
                .build();
        Mockito.when(studentRepository.save(student)).thenReturn(student);
        String message = studentManagementService.saveStudent(student);
        Assertions.assertEquals("Arun has been added successfully", message);
    }


    @Test
    void test_ItCanFetchAll() {
        Student student1 = Student.builder()
                .name("Arun")
                .id(UUID.randomUUID())
                .build();

        Student student2 = Student.builder()
                .name("Vinoth")
                .id(UUID.randomUUID())
                .build();

        StudentResponse studentResponse = StudentResponse.builder()
                .build();
        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);

        Mockito.when(studentRepository.findAll()).thenReturn(students);

//        Mockito.when(studentMapperUtils.mapToStudentResponse(student1)).thenReturn(studentResponse);

        List<StudentResponse> studentResponse1 = studentManagementService.getAllStudents();

        Assertions.assertEquals(2, studentResponse1.size());
    }

}
