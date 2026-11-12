package com.pcl.pos.bo.custom;

import com.pcl.pos.bo.SuperBo;
import com.pcl.pos.dto.request.CustomerRequestDto;
import com.pcl.pos.dto.response.ResponseCustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBo extends SuperBo {
        public boolean save(CustomerRequestDto dto) throws SQLException, ClassNotFoundException;
        public List<ResponseCustomerDto>  getAllCustomers() throws SQLException, ClassNotFoundException;
        public boolean delete(String id) throws SQLException, ClassNotFoundException;
        public boolean updateCustomer(CustomerRequestDto dto,String id) throws SQLException, ClassNotFoundException;
}
