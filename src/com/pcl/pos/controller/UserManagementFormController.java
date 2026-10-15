package com.pcl.pos.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class UserManagementFormController {
    public AnchorPane userManagementContext;
    public TextField txtUsrName;
    public PasswordField txtPwd;
    public TextField txtEmail;
    public TextField txtContactNumber;
    public ComboBox cmbRole;
    public RadioButton rdoApproved;
    public ToggleGroup status;
    public RadioButton rdoPending;
    public TableView tblUsers;
    public TableColumn colId;
    public TableColumn colUserName;
    public TableColumn colEmail;
    public TableColumn colRole;
    public TableColumn colOption;
    public Button btnSave;

    public void saveOnAction(ActionEvent actionEvent) {

    }
}
