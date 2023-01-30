package com.example.employee.pojo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
//import java.lang.annotation.Target;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private String id;
    @Column
    @Getter
    private String name;
    @Column
    @JsonIgnore
    private Date lastAccessDate;
    @Column
    @JsonIgnore
    private boolean isActive;
}
