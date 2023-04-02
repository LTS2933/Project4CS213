package src.project4cs213;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class StoreOrdersController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField ordersDetails;

    @FXML
    private Button cancelButton;

    @FXML
    private Button exportToTextFileButton;

    @FXML
    private Button backToMainViewButton;

    @FXML
    protected void showMainViewScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
