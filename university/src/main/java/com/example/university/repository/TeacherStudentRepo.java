package com.example.university.repository;

import com.example.university.pojo.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherStudentRepo {
    Student findById(String id);

    String insertToStudent(String id, String name);

    String RemoveToStudent(String id);

    public String UpdateStudent(String id, String name);
}
