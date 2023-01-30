package com.example.search.service;

import org.springframework.http.ResponseEntity;

public interface SearchService {
    ResponseEntity<String> getDetails();
}
