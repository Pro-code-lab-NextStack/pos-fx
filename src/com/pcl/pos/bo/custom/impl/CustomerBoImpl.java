package com.pcl.pos.bo.custom.impl;

import com.pcl.pos.bo.custom.CustomerBo;
import com.pcl.pos.dao.custom.CustomerDao;
import com.pcl.pos.dao.custom.impl.CustomerDaoImpl;
import com.pcl.pos.dto.request.CustomerRequestDto;
import com.pcl.pos.dto.response.ResponseCustomerDto;
import com.pcl.pos.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerBoImpl implements CustomerBo {
    CustomerDao customerDao=new CustomerDaoImpl();
    @Override
    public boolean save(CustomerRequestDto dto) throws SQLException, ClassNotFoundException {
        Customer customer=customerDao.findCustomerByEmail(dto.getEmail());
        if (customer!=null){
            return false;
        }
      return   customerDao.save(new Customer(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getSalary(),
                dto.getContact(),
                dto.getAddress(),
                dto.getEmail()
        ));

    }

    @Override
    public List<ResponseCustomerDto> getAllCustomers() throws SQLException, ClassNotFoundException {
       List<Customer> customerList= customerDao.findAll();
       List<ResponseCustomerDto> dtoList=new ArrayList<>();
       for (Customer c:customerList){
           dtoList.add(new ResponseCustomerDto(
                   c.getId(),
                   c.getName(),
                   c.getSalary(),
                   c.getContact(),
                   c.getAddress(),
                   c.getEmail()
           ));
       }

        return dtoList;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Customer byId = customerDao.findById(id);
        if (byId!=null){
            return customerDao.delete(id);

        }
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerRequestDto dto,String id) throws SQLException, ClassNotFoundException {
        Customer customerByEmail = customerDao.findCustomerByEmail(dto.getEmail());
        if (customerByEmail!=null){
           return customerDao.update(new Customer(
                    id,
                    dto.getName(),
                    dto.getSalary(),
                    dto.getContact(),
                    dto.getAddress(),
                    dto.getEmail()

            ));
        }
        return false;
    }
}
