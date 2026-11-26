package com.pcl.pos.dao.custom.impl;

import com.pcl.pos.dao.CrudUtill;
import com.pcl.pos.dao.custom.VendorDao;
import com.pcl.pos.entity.Vendor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDaoImpl implements VendorDao {
    @Override
    public boolean save(Vendor vendor) throws ClassNotFoundException, SQLException {
        String sql="INSERT INTO vendor VALUES (?,?,?,?)";
       return CrudUtill.execute(sql,
                vendor.getId(),vendor.getName(),vendor.getPhone(),vendor.getAddress());
    }

    @Override
    public boolean update(Vendor vendor) throws SQLException, ClassNotFoundException {
       return CrudUtill.execute(
                "UPDATE vendor SET name=?,phone=?,address=? WHERE id=?",
                vendor.getName(),vendor.getPhone(),vendor.getAddress(),vendor.getId());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
      return   CrudUtill.execute("DELETE FROM vendor WHERE id=?",s);
    }

    @Override
    public Vendor findById(String s) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM vendor WHERE id=?";
      ResultSet set = CrudUtill.execute(sql,s);
      if (set.next()){
          return new Vendor(
                  set.getString(1),
                  set.getString(2),
                  set.getString(3),
                  set.getString(4)
          );
      }
      return null;
    }

    @Override
    public List<Vendor> findAll() throws SQLException, ClassNotFoundException {
        List<Vendor> vendorList=new ArrayList<>();
       String sql="SELECT * FROM vendor";
     ResultSet set =CrudUtill.execute(sql);
       while (set.next()){
           vendorList.add(new Vendor(
                   set.getString(1),
                   set.getString(2),
                   set.getString(3),
                   set.getString(4)
           ));
       }
       return vendorList;
    }
}
