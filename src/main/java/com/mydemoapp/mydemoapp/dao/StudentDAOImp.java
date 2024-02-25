package com.mydemoapp.mydemoapp.dao;

import com.mydemoapp.mydemoapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // like @component but for DAOs, without  it autowiring will not work
public class StudentDAOImp implements StudentDAO {
    // define field for entity manager
    private EntityManager entityManager;

// inject entity manager using constructor injection
    @Autowired
    public StudentDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method

    @Override
    @Transactional // needed when performing an update to the DB
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findStudentById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAllStudents() {
        // this is not the name of the SQL table but the entity class name
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by id desc",Student.class);
        return theQuery.getResultList();
    }
}
