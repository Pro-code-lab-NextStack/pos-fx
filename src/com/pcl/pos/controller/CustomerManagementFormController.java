package com.pcl.pos.controller;

import com.pcl.pos.bo.custom.CustomerBo;
import com.pcl.pos.bo.custom.impl.CustomerBoImpl;
import com.pcl.pos.dto.request.CustomerRequestDto;
import com.pcl.pos.dto.response.ResponseCustomerDto;
import com.pcl.pos.view.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;
import java.util.List;

public class CustomerManagementFormController {

    public AnchorPane context;
    public TextField txtCustomerName;
    public TextField txtSalary;
    public TextField txtContactNumber;
    public TableView<CustomerTm> tblCustomer;
    public TableColumn<CustomerTm,String> colId;
    public TableColumn <CustomerTm,String>colCustomerName;
    public TableColumn <CustomerTm,String>colEmail;
    public TableColumn <CustomerTm,String>colSalary;
    public TableColumn<CustomerTm,String> colContact;
    public TableColumn<CustomerTm,String> colAddress;
    public TableColumn<CustomerTm,Button> colOption;
    public Button btnSave;
    public TextField txtAddress;
    public TextField txtEmail;
    CustomerBo customerBo=new CustomerBoImpl();

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadCustomerTableData();

    }

    private void loadCustomerTableData() {
        try {
            List<ResponseCustomerDto>  dtos= customerBo.getAllCustomers();
            ObservableList<CustomerTm> customerTms= FXCollections.observableArrayList();
            for (ResponseCustomerDto dto:dtos){
                Button btn=new Button("Delete");
                customerTms.add(new CustomerTm(
                        dto.getId(),
                        dto.getName(),
                        dto.getEmail(),
                        String.valueOf(dto.getSalary()),
                        dto.getContact(),
                        dto.getAddress(),
                        btn
                ));
                tblCustomer.setItems(customerTms);
            }

        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

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
