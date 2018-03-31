package com.app.controllers;

import com.app.model.Student;
import com.app.model.StudentBookDto;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/student")
public class StudentRestController {

    @GetMapping (value = "/all")
    public List<Student> getAllStudents(){

        RestTemplate restTemplate = new RestTemplate();
        final String URL = "http://localhost:8080/student/all";
        ResponseEntity<Student[]> responseEntity = restTemplate.exchange(URL, HttpMethod.GET,null,Student[].class);
        return Arrays.asList(responseEntity.getBody());
    }
    @GetMapping (value = "/book/all")
    public List<StudentBookDto> getAllStudentsWithBooks(){
        RestTemplate restTemplate = new RestTemplate();
        final String URL = "http://localhost:8080/student/book/all";
        ResponseEntity<StudentBookDto> responseEntity = restTemplate.exchange(URL,HttpMethod.GET,null,StudentBookDto.class);
        return Arrays.asList(responseEntity.getBody());
    }
    @GetMapping (value = "/book/{id}")
    public List<Student> getStudentWithBook(@PathVariable Long id){

        RestTemplate restTemplate = new RestTemplate();
        final String URL = "http://localhost:8080/student/book/{id}";

        Map<String,String> params = new HashMap<>();
        params.put("id",String.valueOf(id));

        ResponseEntity<Student[]> responseEntity = restTemplate.exchange(URL,HttpMethod.GET,null,Student[].class, params);
        return Arrays.asList(responseEntity.getBody());
    }

}
