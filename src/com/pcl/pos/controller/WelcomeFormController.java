package com.pcl.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeFormController {
    public AnchorPane context;

    public void loginFormOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }

    public void signupFormOnAction(ActionEvent actionEvent) throws IOException {
     setUi("SignupForm");

    }

    public void setUi(String location) throws IOException {
        Parent parent=FXMLLoader.load(getClass().getResource
                ("/com/pcl/pos/view/"+location+".fxml"));
        javafx.stage.Stage stage =(Stage)context.getScene().getWindow();
        stage.setScene(new Scene(parent));

    }
}
