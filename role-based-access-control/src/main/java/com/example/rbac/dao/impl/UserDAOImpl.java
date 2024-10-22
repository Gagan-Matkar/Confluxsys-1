package com.example.rbac.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import com.example.rbac.dao.UserDAO;
import com.example.rbac.model.User;
import com.example.rbac.util.DatabaseConnection;

public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO users (username , password, email) values (?,?,?)";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());

			int rowsAffected = ps.executeUpdate();
			logger.info("User created successfully , rows affected : {}", rowsAffected);

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			logger.error("Error creating user : {}", e.getMessage());
		}

	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users WHERE user_id = ?";
        User user = null;
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("user_id"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"));
            }
            logger.info("received the information of the user with userID : {}",id);
        } catch (SQLException e) {
            
        }
        return user;
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                User user = new User(rs.getInt("user_id"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE users SET username = ?, password = ?, email = ? WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setInt(4, user.getUserId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM users WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

	}

}
