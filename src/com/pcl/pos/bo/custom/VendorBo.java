package com.pcl.pos.bo.custom;

import com.pcl.pos.bo.SuperBo;
import com.pcl.pos.dto.request.VendorRequestDto;
import com.pcl.pos.dto.response.VendorResponseDto;

import java.sql.SQLException;
import java.util.List;

public interface VendorBo extends SuperBo {
    public boolean save(VendorRequestDto dto) throws SQLException, ClassNotFoundException;
    public boolean update(VendorRequestDto dto,String id) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public VendorResponseDto findById(String id) throws SQLException, ClassNotFoundException;
    public List<VendorResponseDto> getAll( ) throws SQLException, ClassNotFoundException;
}
