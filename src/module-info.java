module POS {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires jdk.unsupported.desktop;
    requires mysql.connector.j;
    requires java.sql;

    opens com.pcl.pos.controller to javafx.fxml;
    opens com.pcl.pos.view to javafx.base;

    exports com.pcl.pos;
}