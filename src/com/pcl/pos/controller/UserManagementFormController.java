package com.pcl.pos.controller;

import com.pcl.pos.bo.custom.UserBo;
import com.pcl.pos.bo.custom.impl.UserBoImpl;
import com.pcl.pos.dto.request.UserRequestDto;
import com.pcl.pos.dto.response.ResponseRolesDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
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
    public TableView tblUsers;
    public TableColumn colId;
    public TableColumn colUserName;
    public TableColumn colEmail;
    public TableColumn colRole;
    public TableColumn colOption;
    public Button btnSave;

    UserBo userBo=new UserBoImpl();
    public void initialize(){
        setRoleData();
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
