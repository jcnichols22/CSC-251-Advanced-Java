module com.example.u4_buttoninpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.u4_buttoninpane to javafx.fxml;
    exports com.example.u4_buttoninpane;
}