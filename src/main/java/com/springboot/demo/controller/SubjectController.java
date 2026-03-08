package com.springboot.demo.controller;


import com.springboot.demo.request.SubjectRequest;
import com.springboot.demo.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/{studentId}")
    public String saveSubjects(@PathVariable String studentId,
                               @RequestBody List<SubjectRequest> subjectRequest) {
        return subjectService.saveSubjects(subjectRequest, studentId);
    }
}
