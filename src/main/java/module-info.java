module com.example.project4 {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.example.project4;
    opens com.example.project4 to javafx.fxml;
}
