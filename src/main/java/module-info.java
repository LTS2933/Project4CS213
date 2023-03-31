module src.project4cs213 {
    requires javafx.controls;
    requires javafx.fxml;


    opens src.project4cs213 to javafx.fxml;
    exports src.project4cs213;
}