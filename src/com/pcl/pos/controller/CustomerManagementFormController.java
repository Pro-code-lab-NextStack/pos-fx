package com.pcl.pos.controller;

import com.pcl.pos.bo.custom.CustomerBo;
import com.pcl.pos.bo.custom.impl.CustomerBoImpl;
import com.pcl.pos.dto.request.CustomerRequestDto;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

public class CustomerManagementFormController {

    public AnchorPane context;
    public TextField txtCustomerName;
    public TextField txtSalary;
    public TextField txtContactNumber;
    public TableView tblCustomer;
    public TableColumn colId;
    public TableColumn colCustomerName;
    public TableColumn colEmail;
    public TableColumn colSalary;
    public TableColumn colContact;
    public TableColumn colAddress;
    public TableColumn colOption;
    public Button btnSave;
    public TextField txtAddress;
    public TextField txtEmail;

    CustomerBo customerBo=new CustomerBoImpl();
    public void saveOnAction(ActionEvent actionEvent) {
        try {
           boolean isSaved= customerBo.save(new CustomerRequestDto(
                    txtCustomerName.getText(),
                    Double.parseDouble(txtSalary.getText()),
                    txtContactNumber.getText(),
                    txtAddress.getText(),
                    txtEmail.getText()

            ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Customer saved").show();
            }else {
                new Alert(Alert.AlertType.WARNING,"Something went wrong please try again...").show();

            }
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}
