package com.pcl.pos.dao.custom.impl;

import com.pcl.pos.dao.custom.UserDao;
import com.pcl.pos.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public boolean save(User user) throws ClassNotFoundException, SQLException {
      Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nextstack_pos","root","1234");
        String sql="INSERT INTO user VALUES (?,?,?,?,?,?)";
        PreparedStatement ps =connection.prepareStatement(sql);
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getUserName());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getEmail());
        ps.setString(5,user.getContactNumber());
        ps.setString(6,user.getRoleId());
       int rowsCount= ps.executeUpdate();
      return rowsCount>0;


    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public User findById(String s) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
