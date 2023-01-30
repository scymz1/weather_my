package com.example.employee.controller;

import com.example.employee.exception.ResourceNotFoundException;
import com.example.employee.pojo.dto.EmployeeDTO;
import com.example.employee.pojo.dto.EmployeeResponseDTO;
import com.example.employee.pojo.entity.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(@Qualifier("EmployeeServiceImpl") EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<EmployeeResponseDTO> getEmp(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(service.getAllEmp(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmpById(@PathVariable String id) {
        System.out.println(id);
        return new ResponseEntity<>(service.getEmpById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> getEmp(@RequestBody Employee employee) {
        return new ResponseEntity<>(service.createEmployee(employee), HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleException() {
        return new ResponseEntity<>("xxx not found", HttpStatus.NOT_FOUND);
    }
}
