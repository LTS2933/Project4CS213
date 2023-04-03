package src.project4cs213;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderingCoffeeController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private RadioButton shortButton;

    @FXML
    private RadioButton tallButton;

    @FXML
    private RadioButton grandeButton;

    @FXML
    private RadioButton ventiButton;

    @FXML
    private TextField numberOfCupsTextField;

    @FXML
    private TextField subTotal;

    @FXML
    private Button addToOrderButton;

    @FXML
    private CheckBox sweetCreamCheckBox;

    @FXML
    private CheckBox frenchVanillaCheckBox;

    @FXML
    private CheckBox irishCreamCheckBox;

    @FXML
    private CheckBox caramelCheckBox;

    @FXML
    private CheckBox mochaCheckBox;

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
