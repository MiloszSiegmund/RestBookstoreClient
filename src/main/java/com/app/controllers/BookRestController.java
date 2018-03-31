package com.app.controllers;

import com.app.model.Book;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping ("book")
public class BookRestController {

    @GetMapping (value = "/all")
    public List<Book> getAllBooks(){
        RestTemplate restTemplate = new RestTemplate();
        final String URL = "http://localhost:8080/book/all";
        ResponseEntity<Book[]> responseEntity = restTemplate.exchange(URL,HttpMethod.GET, null, Book[].class);
        return Arrays.asList(responseEntity.getBody());
    }
}
