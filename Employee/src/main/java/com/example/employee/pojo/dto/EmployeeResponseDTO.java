package com.example.employee.pojo.dto;

import com.example.employee.pojo.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class EmployeeResponseDTO {
    private List<EmployeeDTO> employeeList;


}
