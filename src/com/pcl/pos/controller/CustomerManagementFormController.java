package com.pcl.pos.controller;

import com.pcl.pos.bo.custom.CustomerBo;
import com.pcl.pos.bo.custom.impl.CustomerBoImpl;
import com.pcl.pos.dto.request.CustomerRequestDto;
import com.pcl.pos.dto.response.ResponseCustomerDto;
import com.pcl.pos.entity.Customer;
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

        tblCustomer.getSelectionModel().selectedItemProperty()
                .addListener((observable,oldValue,newValue)->{
                    if (newValue!=null){
                        setData((CustomerTm)newValue);
                    }
                });

    }

    private void setData(CustomerTm tm) {
        txtAddress.setText(tm.getAddress());
        txtContactNumber.setText(tm.getContact());
        txtCustomerName.setText(tm.getName());
        txtSalary.setText(tm.getSalary());
        txtEmail.setText(tm.getEmail());
        btnSave.setText("Update Customer");

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
                btn.setOnAction((event->{
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION,
                            "Are you sure you want to delete this customer",
                            ButtonType.YES,ButtonType.NO);
                    alert.showAndWait();

                    if (alert.getResult()==ButtonType.YES){
                        try {
                            boolean isDeleted=customerBo.delete(dto.getId());
                            if (isDeleted){
                                new Alert(Alert.AlertType.INFORMATION,"Customer Deleted").show();
                                loadCustomerTableData();
                            }else {
                                new Alert(Alert.AlertType.WARNING,"Something went wrong").show();

                            }
                        }catch (SQLException|ClassNotFoundException e){
                            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
                        }
                    }
                }));
            }
            tblCustomer.setItems(customerTms);
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void saveOnAction(ActionEvent actionEvent) {
        try {
            if (btnSave.getText().equals("Save Customer")){
                boolean isSaved= customerBo.save(new CustomerRequestDto(
                        txtCustomerName.getText(),
                        Double.parseDouble(txtSalary.getText()),
                        txtContactNumber.getText(),
                        txtAddress.getText(),
                        txtEmail.getText()

                ));
                if (isSaved){
                    loadCustomerTableData();
                    clearFields();
                    new Alert(Alert.AlertType.INFORMATION,"Customer saved").show();
                }else {
                    new Alert(Alert.AlertType.WARNING,"Something went wrong please try again...").show();

                }
            }else{
                boolean isUpdated = customerBo.updateCustomer(new CustomerRequestDto(
                        txtCustomerName.getText(),
                        Double.parseDouble(txtSalary.getText()),
                        txtContactNumber.getText(),
                        txtAddress.getText(),
                        txtEmail.getText()
                ));
                if (isUpdated){
                    loadCustomerTableData();
                    btnSave.setText("Save Customer");
                    new Alert(Alert.AlertType.INFORMATION,"Customer Updated "+txtEmail.getText()).show();
                    clearFields();
                }
            }

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    public void clearFields(){
        txtEmail.clear();
        txtSalary.clear();
        txtCustomerName.clear();
        txtContactNumber.clear();
        txtAddress.clear();
    }
}
