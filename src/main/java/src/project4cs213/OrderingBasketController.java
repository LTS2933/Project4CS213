package src.project4cs213;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderingBasketController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<String> ordersListView;

    @FXML
    private TextField subTotalTextField;

    @FXML
    private TextField salesTaxTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private Button placeOrderButton;

    @FXML
    private Button backToMainViewButton;
    
    @FXML
    private Button cancelOrderButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    protected void showMainViewScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
