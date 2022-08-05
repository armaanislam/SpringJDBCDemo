package com.seleniumexpress.dao;

import com.seleniumexpress.api.Student;

import java.util.List;

public interface StudentDAO {
    void insert(Student student);

    void insert(List<Student> students);

    boolean deleteRecordByRollNo(int RollNo);

    int deleteRecordByStudentNameOrStudentAddress(String studentName,String studentAddress);
}
