package src.project4cs213;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class OrderingDonutsController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox<String> donutTypeComboBox;

    private String[] donutTypes = {"yeast", "cake", "donut holes"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        donutTypeComboBox.getItems().addAll(donutTypes);
    }

    @FXML
    private ListView<String> flavorsListView;

    @FXML
    private TextField quantityTextField;

    @FXML
    private TextField subTotalTextField;

    @FXML
    private TextArea orderingBasketTextArea;

    @FXML
    private Button addToOrderButton;

    @FXML
    private ImageView donutImageView;

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
