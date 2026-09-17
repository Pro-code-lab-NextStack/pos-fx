package com.pcl.pos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
      /*  URL resource = getClass().getResource("/com/pcl/pos/view/LoginForm.fxml");//catch file
        Parent load = FXMLLoader.load(resource);//load file
        Scene scene = new Scene(load); //create scene
        stage.setScene(scene); // set to stage
        stage.setTitle("SMART POS");
        stage.show();//show*/

        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/pcl/pos/view/LoginForm.fxml"))));
        stage.show();
    }
}
http://localhohttp://localhost:3000/invoicest:3000/invoice