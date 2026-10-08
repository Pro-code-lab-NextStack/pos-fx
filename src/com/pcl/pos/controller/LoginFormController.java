package com.pcl.pos.controller;

import com.pcl.pos.bo.custom.UserBo;
import com.pcl.pos.bo.custom.impl.UserBoImpl;
import com.pcl.pos.dto.request.UserRequestDto;
import com.pcl.pos.dto.response.ResponseUserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public AnchorPane context;
    public TextField txtEmail;
    public PasswordField txtPwd;
    UserBo userBo=new UserBoImpl();
    public void forgotPasswordOnAction(ActionEvent actionEvent) {
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        try {
         ResponseUserDto dto =userBo.login(new UserRequestDto(null,txtEmail.getText(),txtPwd.getText(),null));
         if (dto.getCode()==200){
             new Alert(Alert.AlertType.INFORMATION,dto.getMessage()).show();
             setUi("DashboardForm");
         } else if (dto.getCode()==401) {
             new Alert(Alert.AlertType.WARNING,dto.getMessage()).show();


         }else {
             new Alert(Alert.AlertType.WARNING,dto.getMessage()).show();

         }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void signupOnAction(ActionEvent actionEvent) {
    }
    public void setUi(String location) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource
                ("/com/pcl/pos/view/"+location+".fxml"));
        javafx.stage.Stage stage =(Stage)context.getScene().getWindow();
        stage.setScene(new Scene(parent));

    }
}
