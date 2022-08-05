package com.seleniumexpress.dao;

import com.seleniumexpress.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("studentDao")
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Student student) {
        String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)"; // ? means dynamic
        Object[] arg = {student.getRollNo(), student.getName(), student.getAddress()};
        int noOfRowInserted = jdbcTemplate.update(sql, arg); //(sql, value); We used jdbc.update because after inserting a data, technically the table will be updated
        System.out.println("No. of row inserted is "+noOfRowInserted);
    }

    @Override
    public void insert(List<Student> students) {
        String sql = "INSERT INTO STUDENT VALUES (?, ?, ?)";
        ArrayList<Object[]> sqlArgs = new ArrayList<>();
        for(Student tempStudent: students) {
            Object[] studentData = {tempStudent.getRollNo(), tempStudent.getName(), tempStudent.getAddress()};
            sqlArgs.add(studentData);
        }
        jdbcTemplate.batchUpdate(sql, sqlArgs);
        System.out.println("Batch Updated Completed");
    }

    @Override
    public boolean deleteRecordByRollNo(int rollNo) {
        String sql = "DELETE FROM STUDENT WHERE ROLL_NUM = ?";
        int noOfRowsDeleted = jdbcTemplate.update(sql, rollNo);
        System.out.println("No. of record deleted is "+ noOfRowsDeleted);
        return noOfRowsDeleted == 1;
    }

    @Override
    public int deleteRecordByStudentNameOrStudentAddress(String studentName, String studentAddress) {
        String sql = "DELETE FROM STUDENT WHERE STUDENT_NAME = ? OR STUDENT_ADDRESS = ?";
        Object[] arguments = {studentName, studentAddress}; // Serial must be maintained
        int noOfRowsDeleted = jdbcTemplate.update(sql, arguments);
        System.out.println("No. of rows got deleted "+noOfRowsDeleted);
        // int noOfRowsDeleted = jdbcTemplate.update(sql, studentName, studentAddress); This will also work
        return noOfRowsDeleted;
    }

//    public void cleanUp() {
//        String sql = "TRUNCATE TABLE STUDENT";
//        jdbcTemplate.update(sql); // Better for DML
//        System.out.println("Table truncated");
//    }

    //Better Approach
    public void cleanUp() {
        jdbcTemplate.execute("TRUNCATE TABLE STUDENT"); // Execute runs direct SQL; Better for DDL
        System.out.println("Table truncated");
    }
}
