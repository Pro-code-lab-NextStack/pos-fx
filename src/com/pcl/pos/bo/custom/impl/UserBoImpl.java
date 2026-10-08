package com.pcl.pos.bo.custom.impl;

import com.pcl.pos.bo.custom.UserBo;
import com.pcl.pos.dao.SuperDao;
import com.pcl.pos.dao.custom.UserDao;
import com.pcl.pos.dao.custom.impl.UserDaoImpl;
import com.pcl.pos.dto.request.UserRequestDto;
import com.pcl.pos.entity.User;
import com.pcl.pos.utill.security.PasswordManager;

import java.sql.SQLException;
import java.util.UUID;

public class UserBoImpl implements UserBo {
    UserDao userDao=new UserDaoImpl();
    @Override
    public boolean registerUser(UserRequestDto dto) throws SQLException, ClassNotFoundException {
        if (isExists(dto.getEmail())){
            return false;

        }
        return userDao.save(new User(UUID.randomUUID().toString(),
                dto.getUserName(),
                new PasswordManager().encode(dto.getRowPw()),
                dto.getEmail(),
                dto.getContact(),
                "AD-001"));

    }

    @Override
    public boolean isExists(String email) throws SQLException, ClassNotFoundException {
     User user=  userDao.findByEmail(email);
     if (user!=null){
         return true;
     }
     return false;
    }

}
