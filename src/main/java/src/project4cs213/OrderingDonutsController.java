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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;



public class OrderingDonutsController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox<String> donutTypeComboBox;

    private String[] donutTypes = {"yeast", "cake", "donut holes"};

    private Map<String, Image> donutImages = new HashMap<>();

    @FXML
    private ImageView donutImageView;


    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        donutTypeComboBox.getItems().addAll(donutTypes);

        donutImages.put("yeast", new Image(getClass().getResourceAsStream("Recipe-Photo-New-Low-Carb-Yeasted-Donuts-2-7316.jpg")));
        donutImages.put("cake", new Image(getClass().getResourceAsStream("2174059.jpg")));
        donutImages.put("donut holes", new Image(getClass().getResourceAsStream("easy-homemade-glazed-doughnut-holes-recipe.jpg")));

        donutTypeComboBox.setOnAction(event -> {
            String selectedType = donutTypeComboBox.getValue();
            ObservableList<String> flavors = FXCollections.observableArrayList();
            switch (selectedType) {
                case "yeast":
                    flavors.addAll("Glazed", "Chocolate Frosted", "Vanilla Frosted", "Cinnamon", "Strawberry Frosted");
                    break;
                case "cake":
                    flavors.addAll("Velvet", "Powdered Sugar", "Extra Chocolate");
                    break;
                case "donut holes":
                    flavors.addAll("Sprinkled", "Pumpkin", "Plain");
                    break;
            }
            flavorsListView.setItems(flavors);
            String selectedDonut = donutTypeComboBox.getValue();
            Image selectedImage = donutImages.get(selectedDonut);
            donutImageView.setImage(selectedImage);
        });
    }

    @FXML
    private ListView<String> flavorsListView;

    @FXML
    private TextField quantityTextField;

    @FXML
    private TextField subTotalTextField;

    @FXML
    private TextArea orderingBasketListView;

    @FXML
    private Button addToOrderButton;

    @FXML
    private Button removeFromOrderButton;

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
