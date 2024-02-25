package com.mydemoapp.mydemoapp;

// this consists of : @EnableAutoConfiguration (enable spring's auto-config support), @ComponentScan (enables component scanning), @Configuration (able to register extra beans with @beans)

import com.mydemoapp.mydemoapp.dao.StudentDAO;
import com.mydemoapp.mydemoapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

// app will break when files are moved to other folder giving this error
// Parameter 0 of constructor in com.mydemoapp.mydemoapp.rest.DemoController required a bean of type 'com.mydemoapp.mydemoapp.common.Coach' that could not be found.
//@SpringBootApplication(scanBasePackages = {"com.mydemoapp.mydemoapp", "com.otherpackage.util"})
@SpringBootApplication
public class MydemoappApplication {
    // this bootstraps the entire application
    // spring boot searches recursively for packages to register them under com.mydemoapp.mydemoapp, anything outside this folder will not be added to the project
    // You can add packages manually by scanBasePackages
    public static void main(String[] args) {
        SpringApplication.run(MydemoappApplication.class, args);
    }

//    What are the runners in Spring Boot?
//    Application Runner and Command Line Runner interfaces
//    lets you execute the code after the Spring Boot application is started.
    @Bean
    public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
        return runner ->{
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            saveDoe(studentDAO);
//            findStudentByLastName(studentDAO);
            updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        // retrieve the student based on id
        int id = 1;
        Student myStudent = studentDAO.findStudentById(id);
        System.out.println("The student id: "+id);
        System.out.println("The student : "+myStudent);

        // change lastName
        myStudent.setLastName("7amoraby!");
        // update db
        studentDAO.updateStudent(myStudent);
        System.out.println("The student after update : "+myStudent);
    }

    private void saveDoe(StudentDAO studentDAO) {
        Student doe = new Student("John","Doe","johen@gmail.com");
        studentDAO.save(doe);
    }

    private void findStudentByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastname("Doe");
        for(Student studentMatch : students){
            System.out.println(studentMatch);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAllStudents();
        // display a list of students
        for(Student myStudent : theStudents){
            System.out.println(myStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        Student tempStudent1 = new Student("Potato","Mostafa1","Potato@email.com");
        // save the student
        studentDAO.save(tempStudent1);
        // display id of the save student
        System.out.println("The retried student id: "+tempStudent1.getId());
        // retrieve student based on the id: primary key
        Student myRetrievedStudent = studentDAO.findStudentById(tempStudent1.getId());
        // display the student
        System.out.println("Retried student object: "+myRetrievedStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating 3 student objects...");
        Student tempStudent1 = new Student("Omar1","Mostafa1","omar1@email.com");
        Student tempStudent2 = new Student("Omar2","Mostafa2","omar2@email.com");
        Student tempStudent3 = new Student("Omar3","Mostafa3","omar3@email.com");


        System.out.println("Saving students in DB...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO){
        // create the student object
        System.out.println("Creating a new student object...");
        Student tempStudent = new Student("Omar","Mostafa","omar@email.com");

        // save the student object
        System.out.println("Saving student in DB...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: "+ tempStudent.getId());
    }

}
