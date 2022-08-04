package com.seleniumexpress.test;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.dao.StudentDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("Application context loaded");
        StudentDAOImpl studentDaoImpl = context.getBean("studentDao", StudentDAOImpl.class); // (id from spring.xml, class name)

        Student newStudent1 = new Student();
        newStudent1.setRollNo(1);
        newStudent1.setName("Micky");
        newStudent1.setAddress("Chittagong");

        studentDaoImpl.insert(newStudent1);
    }
}
