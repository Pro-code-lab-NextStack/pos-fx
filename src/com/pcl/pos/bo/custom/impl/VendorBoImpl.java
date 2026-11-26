package com.pcl.pos.bo.custom.impl;

import com.pcl.pos.bo.custom.VendorBo;
import com.pcl.pos.dao.custom.VendorDao;
import com.pcl.pos.dao.custom.impl.VendorDaoImpl;
import com.pcl.pos.dto.request.VendorRequestDto;
import com.pcl.pos.dto.response.VendorResponseDto;
import com.pcl.pos.entity.Vendor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class VendorBoImpl implements VendorBo {
    VendorDao vendorDao=new VendorDaoImpl();
    @Override
    public boolean save(VendorRequestDto dto) throws SQLException, ClassNotFoundException {
        return vendorDao.save(new Vendor(
                UUID.randomUUID().toString(),
                dto.getName(),
                dto.getPhone(),
                dto.getAddress()));
    }

    @Override
    public boolean update(VendorRequestDto dto, String id) throws SQLException, ClassNotFoundException {
        return  vendorDao.update(new Vendor(
                id,
                dto.getName(),
                dto.getPhone(),
                dto.getAddress()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return vendorDao.delete(id);
    }

    @Override
    public VendorResponseDto findById(String id) throws SQLException, ClassNotFoundException {
         Vendor selectedVendor =vendorDao.findById(id);
         if (selectedVendor!=null){
             return new VendorResponseDto(selectedVendor.getId(),
                     selectedVendor.getName(),
                     selectedVendor.getPhone(),
                     selectedVendor.getAddress(),
                     200,
                     "Data recived");
         }
         return new VendorResponseDto(null,null,null,null,404,"Not found");

    }

    @Override
    public List<VendorResponseDto> getAll() throws SQLException, ClassNotFoundException {
        List<Vendor> vendorList=vendorDao.findAll();
        List<VendorResponseDto> vendorResponseDtos=new ArrayList<>();
        for (Vendor selectedVendor:vendorList){
            new VendorResponseDto(
                    selectedVendor.getId(),
                    selectedVendor.getName(),
                    selectedVendor.getPhone(),
                    selectedVendor.getAddress(),
                    200,
                    "Data recived"
            );
        }
        return vendorResponseDtos;
    }
}
