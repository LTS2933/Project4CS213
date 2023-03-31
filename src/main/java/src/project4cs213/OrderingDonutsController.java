package src.project4cs213;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderingDonutsController implements Initializable {

    @FXML
    private ComboBox<String> donutTypeComboBox;

    private String[] donutTypes = {"yeast", "cake", "donut holes"};
    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        donutTypeComboBox.getItems().addAll(donutTypes);
    }

    @FXML
    private ListView flavorsListView;

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
}
