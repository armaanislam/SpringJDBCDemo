package com.seleniumexpress.rowmapper;

import com.seleniumexpress.api.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Student student = new Student();

        student.setRollNo(resultSet.getInt("ROLL_NUM"));
        student.setName(resultSet.getString("STUDENT_NAME"));
        student.setAddress(resultSet.getString("STUDENT_ADDRESS"));

        return student;
    }

}

