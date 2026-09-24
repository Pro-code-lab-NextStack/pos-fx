package com.pcl.pos.controller;

import com.pcl.pos.model.User;
import com.pcl.pos.utill.security.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public void signupOnAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
       String userName =txtUsrNme.getText();
       String email=txtEml.getText();
       String contact=txtCntctNmbr.getText();
       String password=txtPwd.getText();
       String pwdConfirmation=txtCnfrmPwd.getText();
       String userId="USER-001";
       String roleId="AD-001";

       User user=new User(userId,userName,new PasswordManager().encode(password),email,contact,roleId);

        saveUser(user);


    }

    public boolean saveUser(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nextstack_pos","root","1234");
        String sql="INSERT INTO user VALUES (?,?,?,?,?,?)";
        PreparedStatement ps =connection.prepareStatement(sql);
        ps.setString(1,user.getId());
        ps.setString(2,user.getUserName());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getEmail());
        ps.setString(5,user.getContactNumber());
        ps.setString(6,user.getUserRole());
       int rowCount =ps.executeUpdate();
        return rowCount>0;

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
