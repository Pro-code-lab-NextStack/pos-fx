package com.pcl.pos.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SuperAdminFormController {
    public AnchorPane mainContext;
    public AnchorPane leftContext;
    public AnchorPane dynamicContext;
    public AnchorPane statsContext;
    public Label lblTime;
    public Hyperlink hyperProfile;

    public void navigateDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashboardForm");
    }
    private void setUi(String location) throws IOException {
        dynamicContext.getChildren().clear();
        dynamicContext.getChildren().add(
                FXMLLoader.load(
                        getClass().getResource
                                ("/com/pcl/pos/view/"+location+".fxml"))
        );
    }
}
