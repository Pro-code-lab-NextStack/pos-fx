package com.pcl.pos.dao.custom;

import com.pcl.pos.dao.CrudDao;
import com.pcl.pos.entity.Role;
import com.pcl.pos.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends CrudDao<User,String> {
    public User findByEmail(String email) throws SQLException, ClassNotFoundException;
    public List<Role> getAllRoles() throws SQLException, ClassNotFoundException;
}
