package com.pcl.pos.bo.custom;

import com.pcl.pos.bo.SuperBo;
import com.pcl.pos.dto.request.UserRequestDto;
import com.pcl.pos.dto.response.ResponseUserDto;
import com.pcl.pos.entity.User;

import java.sql.SQLException;

public interface UserBo extends SuperBo {
    public boolean registerUser(UserRequestDto dto) throws SQLException, ClassNotFoundException;
    public User isExists(String email) throws SQLException, ClassNotFoundException;
    public ResponseUserDto login(UserRequestDto dto) throws SQLException, ClassNotFoundException;
}
