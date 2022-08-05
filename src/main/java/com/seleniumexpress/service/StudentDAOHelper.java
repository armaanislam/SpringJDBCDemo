package com.seleniumexpress.service;

import com.seleniumexpress.api.Student;
import com.seleniumexpress.dao.StudentDAO;
import com.seleniumexpress.dao.StudentDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("studentDAOHelper")
public class StudentDAOHelper {

    // private StudentDAOImpl studentDAOImpl;
    @Autowired
    private StudentDAO studentDAOImpl; // It is a good practice to use the interface class instead; as StudentDAOImpl implements StudentDAO

    public void setupStudentTable() {

        Student student1 = new Student();
        student1.setRollNo(001);
        student1.setName("Armaan");
        student1.setAddress("Dhaka");

        Student student2 = new Student();
        student2.setRollNo(002);
        student2.setName("Shakib");
        student2.setAddress("Chittagong");

        Student student3 = new Student();
        student3.setRollNo(003);
        student3.setName("Nahid");
        student3.setAddress("Dhaka");

        Student student4 = new Student();
        student4.setRollNo(004);
        student4.setName("Ali");
        student4.setAddress("Khulna");

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);
        studentArrayList.add(student4);

        studentDAOImpl.insert(studentArrayList);
    }
}
