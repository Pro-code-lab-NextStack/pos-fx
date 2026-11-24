package com.pcl.pos.controller.cashier;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeCashierController {
    public AnchorPane context;
    public Button btnLogout;
    public Button btnShiftStaus;

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }

    public void navigatePOSAreaOnAction(ActionEvent actionEvent) throws IOException {
        setUi("cashier/POSContext");
    }

    public void changeShiftStatusOnAction(ActionEvent actionEvent) {
    }

    public void navigatePayOutAreaOnAction(ActionEvent actionEvent) {
    }

    public void navigateHistoryAreaOnAction(ActionEvent actionEvent) {
    }

    public void navigateInventoryAreaOnAction(ActionEvent actionEvent) {
    }

    public void navigateReturnProdAreaOnAction(ActionEvent actionEvent) {
    }

    public void navigateCustomerAreaOnAction(ActionEvent actionEvent) {
    }
    public void setUi(String location) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource
                ("/com/pcl/pos/view/"+location+".fxml"));
        javafx.stage.Stage stage =(Stage)context.getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.setMaximized(true);

    }
}
