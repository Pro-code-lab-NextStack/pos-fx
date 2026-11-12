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
        Connection con=DbConnection.getInstance().getConnection();
        String sql="UPDATE customer SET name=?,salary=?,contact_number=?,address=?,email=? WHERE id=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,customer.getName());
        ps.setDouble(2,customer.getSalary());
        ps.setString(3,customer.getContact());
        ps.setString(4,customer.getAddress());
        ps.setString(5,customer.getEmail());
        ps.setString(6,customer.getId());
       return ps.executeUpdate()>0;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
       Connection con=DbConnection.getInstance().getConnection();
       String sql="DELETE FROM customer WHERE id=?";
       PreparedStatement ps=con.prepareStatement(sql);
       ps.setString(1,s);
       return ps.executeUpdate()>0;
    }

    @Override
    public Customer findById(String s) throws SQLException, ClassNotFoundException {
        Connection con=DbConnection.getInstance().getConnection();
        String sql="SELECT * FROM customer WHERE id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,s);
        ResultSet set = preparedStatement.executeQuery();
        if (set.next()){
            return new Customer(
                    set.getString(1),
                    set.getString(2),
                    set.getDouble(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6)
            );
        }
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

    @Override
    public Customer findCustomerByEmail(String email) throws SQLException, ClassNotFoundException {
       Connection con=DbConnection.getInstance().getConnection();
       String sql="SELECT * FROM customer WHERE email=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1,email);
        ResultSet set = preparedStatement.executeQuery();
        if (set.next()){
            return new Customer(
                    set.getString(1),
                    set.getString(2),
                    set.getDouble(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6)
                    );
        }
        return null;
    }
}
