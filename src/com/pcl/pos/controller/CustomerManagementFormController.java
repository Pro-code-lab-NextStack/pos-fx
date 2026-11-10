package com.pcl.pos.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    public void saveOnAction(ActionEvent actionEvent) {
    }
}
