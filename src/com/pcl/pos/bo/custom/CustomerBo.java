package com.pcl.pos.bo.custom;

import com.pcl.pos.bo.SuperBo;
import com.pcl.pos.dto.request.CustomerRequestDto;

import java.sql.SQLException;

public interface CustomerBo extends SuperBo {
        public boolean save(CustomerRequestDto dto) throws SQLException, ClassNotFoundException;
}
