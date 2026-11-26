package com.pcl.pos.controller;

import com.pcl.pos.bo.SuperBo;
import com.pcl.pos.bo.custom.VendorBo;
import com.pcl.pos.bo.custom.impl.VendorBoImpl;
import com.pcl.pos.dto.request.VendorRequestDto;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

public class VendorManagementFormController {
    public AnchorPane context;
    public TextField txtName;
    public TextField txtContactNumber;
    public TableView tblAddress;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colOption;
    public Button btnSave;
    public TextField txtAddress;
    VendorBo vendorBo=new VendorBoImpl();

    public void saveOnAction(ActionEvent actionEvent) {
        try {
            if (btnSave.getText().trim().equals("Save Vendor")){
               boolean isSaved= vendorBo.save(new VendorRequestDto(
                        txtName.getText()
                        ,txtContactNumber.getText()
                        ,txtAddress.getText()));
               if (isSaved){
                   new Alert(Alert.AlertType.INFORMATION,"Vendor Saved "+txtName.getText());
               }
            }else {
                vendorBo.update(new VendorRequestDto(
                        txtName.getText()
                        ,txtContactNumber.getText()
                        ,txtAddress.getText()),null);
            }
        }catch (SQLException|ClassNotFoundException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
}
