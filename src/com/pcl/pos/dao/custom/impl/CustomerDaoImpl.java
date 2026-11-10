package com.pcl.pos.dao.custom.impl;

import com.pcl.pos.dao.custom.CustomerDao;
import com.pcl.pos.db.DbConnection;
import com.pcl.pos.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public  class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(Customer customer) throws ClassNotFoundException, SQLException {
       Connection connection= DbConnection.getInstance().getConnection();
       String sql="INSERT INTO customer VALUES(?,?,?,?,?,?)";
     PreparedStatement ps = connection.prepareStatement(sql);
     ps.setString(1,customer.getId());
     ps.setString(2,customer.getName());
     ps.setDouble(3,customer.getSalary());
     ps.setString(4,customer.getContact());
     ps.setString(5,customer.getAddress());
     ps.setString(6,customer.getEmail());

    return ps.executeUpdate()>0;


    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Customer findById(String s) {
        return null;
    }

    @Override
    public List<Customer> findAll() throws SQLException, ClassNotFoundException {
        List <Customer> customerList=new ArrayList<>();
     Connection connection = DbConnection.getInstance().getConnection();
     String sql="SELECT * FROM customer";
     PreparedStatement ps=connection.prepareStatement(sql);
    ResultSet rs= ps.executeQuery();
    while (rs.next()){
        customerList.add(new Customer(
             rs.getString(1) ,
             rs.getString(2),
             rs.getDouble(3),
             rs.getString(4),
             rs.getString(5),
             rs.getString(6)
        ));
    }
    return customerList;
    }
}
