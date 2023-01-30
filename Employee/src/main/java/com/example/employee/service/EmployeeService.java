package com.example.employee.service;


import com.example.employee.pojo.dto.EmployeeDTO;
import com.example.employee.pojo.dto.EmployeeResponseDTO;
import com.example.employee.pojo.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeResponseDTO getAllEmp();
    EmployeeDTO getEmpById(String id);

    String createEmployee(Employee employee);
}
