package com.pcl.pos.controller;

import com.pcl.pos.bo.custom.UserBo;
import com.pcl.pos.bo.custom.impl.UserBoImpl;
import com.pcl.pos.dto.request.UserRequestDto;
import com.pcl.pos.dto.response.ResponseRolesDto;
import com.pcl.pos.dto.response.ResponseUserDto;
import com.pcl.pos.view.tm.UserTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;
import java.util.List;

public class UserManagementFormController {
    public AnchorPane userManagementContext;
    public TextField txtUsrName;
    public PasswordField txtPwd;
    public TextField txtEmail;
    public TextField txtContactNumber;
    public ComboBox <String>cmbRole;
    public RadioButton rdoApproved;
    public ToggleGroup status;
    public RadioButton rdoPending;
    public TableView <UserTm>tblUser;
    public TableColumn <UserTm,String>colId;
    public TableColumn<UserTm,String> colUserName;
    public TableColumn<UserTm,String> colEmail;
    public TableColumn<UserTm,String> colRole;
    public TableColumn <UserTm,Button>colOption;
    public Button btnSave;

    UserBo userBo=new UserBoImpl();
    public void initialize(){
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));
        setRoleData();
        setTableData();

        tblUser.getSelectionModel().selectedItemProperty().
                addListener((observable,oldValue,newValue )-> {
                    if (newValue!=null){
                        setData((UserTm)newValue);

                    }
                });

    }

    private void setData(UserTm newValue) {
        btnSave.setText("Update");
        txtEmail.setText(newValue.getEmail());
        cmbRole.setValue(newValue.getRole());
        txtUsrName.setText(newValue.getUserName());
        txtPwd.setText(newValue.getId());

    }

    private void setTableData() {
        try {
            List<ResponseUserDto> userDtos=userBo.getAllUsers();
            ObservableList<UserTm> userObList=FXCollections.observableArrayList();
            for (ResponseUserDto dto:userDtos){
                Button btn=new Button("Delete");
                UserTm userTm=new UserTm(
                        dto.getUserId(),
                        dto.getUserName(),
                        dto.getEmail(),
                        dto.getRoleName(),
                        btn
                );
                btn.setOnAction((event->{
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION,
                            "Are you sure you want to delete this user ?",
                            ButtonType.YES,ButtonType.NO);
                    alert.showAndWait();
                    if (alert.getResult()==ButtonType.YES){
                        try {
                           boolean isDeleted=userBo.deleteUserById(dto.getUserId());
                           if (isDeleted){
                               new Alert(Alert.AlertType.INFORMATION,"User Deleted").show();
                               setTableData();
                               return;
                           }
                            new Alert(Alert.AlertType.WARNING,"Something went wrong").show();

                        }catch (ClassNotFoundException|SQLException e){
                            e.printStackTrace();
                        }
                    }
                }));
                userObList.add(userTm);
            }
            tblUser.setItems(userObList);

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void setRoleData() {
        try {
            List<ResponseRolesDto> dtoList =  userBo.fetchAllRoles();
           ObservableList<String> rolesObList =
                   FXCollections.observableArrayList();
           for (ResponseRolesDto dto:dtoList){
               rolesObList.add(dto.getId()+"-"+dto.getRole());
           }
           cmbRole.setItems(rolesObList);


        }catch (SQLException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void saveOnAction(ActionEvent actionEvent) {
        try {
           boolean isSaved= userBo.registerUser(new UserRequestDto(
                    txtUsrName.getText(),
                    txtEmail.getText(),
                    txtPwd.getText(),
                    txtContactNumber.getText(),
                    splitRoleId(cmbRole.getValue())


            ));
           if (isSaved){
               System.out.println("done");
           }
        }catch (SQLException |ClassNotFoundException e){
            e.printStackTrace();
        }




    }
    public String splitRoleId(String comboText){
        String arr[]=comboText.split("-");
       String roleId= arr[0]+"-"+arr[1];
        System.out.println(roleId);
       return roleId;
    }
}
