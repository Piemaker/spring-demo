package com.mydemoapp.mydemoapp.dao;

import com.mydemoapp.mydemoapp.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findStudentById(Integer id);
}
