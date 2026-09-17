package com.pcl.pos.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class WelcomeFormController {
    public AnchorPane context;

    public void loginFormOnAction(ActionEvent actionEvent) {
        System.out.println("clicked login");
    }

    public void signupFormOnAction(ActionEvent actionEvent){
        System.out.println("clicked signup");

    }
}
