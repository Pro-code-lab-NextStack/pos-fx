package com.pcl.pos.bo.custom.impl;

import com.pcl.pos.bo.custom.UserBo;
import com.pcl.pos.dao.SuperDao;
import com.pcl.pos.dao.custom.UserDao;
import com.pcl.pos.dao.custom.impl.UserDaoImpl;
import com.pcl.pos.dto.request.UserRequestDto;
import com.pcl.pos.dto.response.ResponseUserDto;
import com.pcl.pos.entity.User;
import com.pcl.pos.utill.security.PasswordManager;

import java.sql.SQLException;
import java.util.UUID;

public class UserBoImpl implements UserBo {
    UserDao userDao=new UserDaoImpl();
    @Override
    public boolean registerUser(UserRequestDto dto) throws SQLException, ClassNotFoundException {
        if (isExists(dto.getEmail())==null){
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
    public User isExists(String email) throws SQLException, ClassNotFoundException {
     User user=  userDao.findByEmail(email);
     if (user!=null){
         return user;
     }
     return null;
    }

    @Override
    public ResponseUserDto login(UserRequestDto dto) throws SQLException, ClassNotFoundException {
        User user=isExists(dto.getEmail());

        if (user!=null){
           if (new PasswordManager().check(dto.getRowPw(),user.getPassword())){
               return new ResponseUserDto(user.getEmail(),
                       user.getUserName(),
                       200,
                       "done....");
           }
           return new ResponseUserDto(user.getEmail(),
                   user.getUserName(),
                   401,
                   "Incorrect password please check your pwd....");
       }
      return   new ResponseUserDto(user.getEmail(),
                user.getUserName(),
                404,
                "User not found");
    }


}
