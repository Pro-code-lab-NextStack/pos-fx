package com.pcl.pos.dao.custom.impl;

import com.pcl.pos.dao.custom.UserDao;
import com.pcl.pos.db.DbConnection;
import com.pcl.pos.entity.User;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User findByEmail(String email) throws SQLException, ClassNotFoundException {
     Connection connection = DbConnection.getInstance().getConnection();
     String sql="SELECT * FROM user WHERE email=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,email);
        ResultSet set = ps.executeQuery();
        if (set.next()){
            return new User(set.getString(1),
                            set.getString(2),
                            set.getString(3),
                            set.getString(4),
                            set.getString(5),
                            set.getString(6)
                    );
        }
        return null;

    }

    @Override
    public boolean save(User user) throws ClassNotFoundException, SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
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
