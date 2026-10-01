package com.pcl.pos.dao.custom;

import com.pcl.pos.dao.CrudDao;
import com.pcl.pos.entity.User;

public interface UserDao extends CrudDao<User,String> {
    public User findByEmail(String email);
}
