package com.pcl.pos.controller;

import com.pcl.pos.bo.custom.UserBo;
import com.pcl.pos.bo.custom.impl.UserBoImpl;
import com.pcl.pos.dto.request.UserRequestDto;
import com.pcl.pos.model.User;
import com.pcl.pos.utill.security.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.sql.*;

public class SignUpFormController {
    public TextField txtUsrNme;
    public TextField txtEml;
    public TextField txtCntctNmbr;
    public PasswordField txtPwd;
    public PasswordField txtCnfrmPwd;
    public AnchorPane cntxt;
    UserBo userBo=new UserBoImpl();
    public void signupOnAction(ActionEvent actionEvent) throws IOException {
        try {
            boolean isRegisterd= userBo.registerUser(new UserRequestDto(
                    txtUsrNme.getText(),
                    txtEml.getText(),
                    txtPwd.getText(),
                    txtCntctNmbr.getText()

            ));
            if (isRegisterd){
               new Alert(Alert.AlertType.INFORMATION,"Registration Success...").show();
               setUi("LoginForm");

                return;
            }
                 new Alert(Alert.AlertType.ERROR,"Some thing went wrong").show();
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

    }


    public void backToHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("WelcomeForm");
    }



    public void setUi(String location) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource
                ("/com/pcl/pos/view/"+location+".fxml"));
        javafx.stage.Stage stage =(Stage)cntxt.getScene().getWindow();
        stage.setScene(new Scene(parent));

    }
}
