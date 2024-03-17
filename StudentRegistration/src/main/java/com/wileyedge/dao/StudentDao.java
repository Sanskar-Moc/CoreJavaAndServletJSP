package com.wileyedge.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wileyedge.model.Student;

public class StudentDao {
    private String url;
    private String username;
    private String password;

    public StudentDao(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void registerStudent(Student student) throws SQLException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO students (name, age, mobile, address) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, student.getName());
                stmt.setInt(2, student.getAge());
                stmt.setLong(3, student.getMobNo());
                stmt.setString(4, student.getAddress());
                stmt.executeUpdate();
            }
        }
    }
}
