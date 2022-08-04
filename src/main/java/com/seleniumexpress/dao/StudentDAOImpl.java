package com.seleniumexpress.dao;

import com.seleniumexpress.api.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDAOImpl implements StudentDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Student student) {
        String sql = "INSERT INTO STUDENT VALUES(?, ?, ?)";
        Object[] arg = {student.getRollNo(), student.getName(), student.getAddress()};
        int noOfRecord = jdbcTemplate.update(sql, arg);
        System.out.println("No. of row inserted is "+noOfRecord);
    }
}
