package com.pcl.pos.bo.custom.impl;

import com.pcl.pos.bo.custom.CustomerBo;
import com.pcl.pos.dao.custom.CustomerDao;
import com.pcl.pos.dao.custom.impl.CustomerDaoImpl;
import com.pcl.pos.dto.request.CustomerRequestDto;
import com.pcl.pos.entity.Customer;

import java.sql.SQLException;
import java.util.UUID;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao=new CustomerDaoImpl();
    @Override
    public boolean save(CustomerRequestDto dto) throws SQLException, ClassNotFoundException {
      return   customerDao.save(new Customer(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getSalary(),
                dto.getContact(),
                dto.getAddress(),
                dto.getEmail()
        ));

    }
}
