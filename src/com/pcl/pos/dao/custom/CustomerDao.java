package com.pcl.pos.dao.custom;

import com.pcl.pos.dao.CrudDao;
import com.pcl.pos.entity.Customer;

import java.sql.SQLException;

public interface CustomerDao extends CrudDao<Customer,String> {
    public Customer findCustomerByEmail(String email) throws SQLException, ClassNotFoundException;

}
