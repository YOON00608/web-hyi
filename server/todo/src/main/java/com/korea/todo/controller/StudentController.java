package com.korea.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.todo.dto.ResponseDTO;
import com.korea.todo.dto.StudentDTO;
import com.korea.todo.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") 
public class StudentController {
    private final StudentService studentService;
    
    @GetMapping
    public ResponseDTO<StudentDTO> getStudents(){
        List<StudentDTO> list = studentService.getStudents();
        return new ResponseDTO<StudentDTO>(null, list);
    }
    
    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.addStudent(studentDTO);
    }
}