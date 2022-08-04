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

        // Deletetion by ID
        boolean isDeleted = studentDaoImpl.deleteRecordByRollNo(2);
        if(isDeleted) {
            System.out.println("The roll no. 2 data got deleted");
        }


    }
}