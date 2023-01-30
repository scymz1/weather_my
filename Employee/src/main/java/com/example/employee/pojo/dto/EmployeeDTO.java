package com.example.employee.pojo.dto;

import com.example.employee.pojo.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private String id;
    private String name;

    public EmployeeDTO(Employee e) {
        this.id = e.getId();
        this.name = e.getName();
    }
}