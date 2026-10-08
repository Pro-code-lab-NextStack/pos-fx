package com.pcl.pos.bo.custom;

import com.pcl.pos.bo.SuperBo;
import com.pcl.pos.dto.request.UserRequestDto;

import java.sql.SQLException;

public interface UserBo extends SuperBo {
    public boolean registerUser(UserRequestDto dto) throws SQLException, ClassNotFoundException;
    public boolean isExists(String email) throws SQLException, ClassNotFoundException;

}
