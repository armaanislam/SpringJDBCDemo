package com.seleniumexpress.test;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.dao.StudentDAOImpl;
import com.seleniumexpress.service.StudentDAOHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("Application context loaded");

        StudentDAOHelper studentDAOHelper = context.getBean("studentDAOHelper", StudentDAOHelper.class);

//        //Set Up Table
//        studentDAOHelper.setupStudentTable();


        StudentDAOImpl studentDaoImpl = context.getBean("studentDao", StudentDAOImpl.class); // (id from spring.xml, class name)

//        Insertion
//        Student newStudent1 = new Student();
//        newStudent1.setRollNo(005);
//        newStudent1.setName("Micky");
//        newStudent1.setAddress("Chittagong");
//
//        studentDaoImpl.insert(newStudent1);


//        Deletetion by ID
//        boolean isDeleted = studentDaoImpl.deleteRecordByRollNo(2);
//        if(isDeleted) {
//            System.out.println("The roll no. 2 data got deleted");
//        }


//        //Deletion by Name and Address
//        studentDaoImpl.deleteRecordByStudentNameOrStudentAddress("John", "Dhaka");


//        // Table Clean up
//        studentDaoImpl.cleanUp();

//        // SELECT Row Mapper
//        List<Student> studentList = studentDaoImpl.findAllStudents();
//        studentDAOHelper.printStudents(studentList);

        // Find a single object
        Student student = studentDaoImpl.findStudentByRollNo(2);
        System.out.println(student);

    }
}