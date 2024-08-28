package com.coffeetalk.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.coffeetalk.config.ConnectionManager;
import com.coffeetalk.model.User;
import com.coffeetalk.security.PasswordHasher;

public class UserDAO {
	private Connection connection;
	
	public UserDAO() throws SQLException {
		this.connection = ConnectionManager.getInstance().getConnection();
	}
	
	public boolean create(User user) throws NoSuchAlgorithmException {
		PreparedStatement stmt = null;
		
		try {
			String sql = "INSERT INTO users(username,email,password) VALUES(?,?,?)";
	
			stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, PasswordHasher.hashPassword(user.getPassword()));

            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0;
		} catch (NoSuchAlgorithmException | SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	
	public User getByUsername(String username) throws SQLException {
		String sql = "SELECT u.username, u.email, u.password FROM users where u.username = ?";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, username);
		
		ResultSet rs = stmt.executeQuery();
		
        if (!rs.next()) {
        	return null;
        }
        
        User user = new User(
    		rs.getLong("id"), 
    		rs.getString("username"), 
    		rs.getString("email"), 
    		rs.getString("password"), 
    		rs.getObject("created_at", LocalDateTime.class),
    		rs.getObject("updated_at", LocalDateTime.class)
        );
		
		return user;
	}
}
