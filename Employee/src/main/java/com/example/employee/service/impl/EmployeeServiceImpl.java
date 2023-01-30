package com.example.employee.service.impl;
import com.example.employee.exception.ResourceNotFoundException;
import com.example.employee.pojo.dto.EmployeeDTO;
import com.example.employee.pojo.dto.EmployeeResponseDTO;
import com.example.employee.pojo.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component("EmployeeServiceImpl")
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDTO getAllEmp() {
        Collection<Employee> employeeCollection = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = employeeCollection
                    .stream()
                    .map(e -> new EmployeeDTO(e))
                    .collect(Collectors.toList());
        return new EmployeeResponseDTO(employeeDTOS);
    }

    @Override
    public EmployeeDTO getEmpById(String id) {
        //log id
        System.out.println(id);
        Employee employee = employeeRepository.getById(id);
        //log employee info
        if(employee==null) {
            //log..
            throw new ResourceNotFoundException("..");
        }
        return new EmployeeDTO(employee);
    }

    @Override
    @Transactional
    public String createEmployee(Employee employee) {
        this.employeeRepository.save(employee);
        return employee.getId();
    }


}
