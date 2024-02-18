package com.mydemoapp.mydemoapp;

// this consists of : @EnableAutoConfiguration (enable spring's auto-config support), @ComponentScan (enables component scanning), @Configuration (able to register extra beans with @beans)

import com.mydemoapp.mydemoapp.dao.StudentDAO;
import com.mydemoapp.mydemoapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            createStudent(studentDAO);
        };
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
