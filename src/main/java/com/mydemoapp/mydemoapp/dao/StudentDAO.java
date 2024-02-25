package com.mydemoapp.mydemoapp.dao;

import com.mydemoapp.mydemoapp.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findStudentById(Integer id);

    List<Student> findAllStudents();

    List<Student> findByLastname(String lastName);

    void updateStudent(Student theStudent);

    void removeStudent(Integer id);

    void removeStudentQuery(Integer id);

    int deleteAll();
}
