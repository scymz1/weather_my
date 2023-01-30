package com.example.search.pojo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Getter
    private String id;

    @Getter
    private String name;

    @JsonIgnore
    private Date lastAccessDate;

    @JsonIgnore
    private boolean isActive;
}
