package com.example.project4;

import com.example.project4.model.Donut;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * This class is responsible for handling events and interactions in the
 * ordering donuts view. Contains methods for adding and removing specific donut
 * orders to the current order.
 * @author Christian Osma, Liam Smith
 */
public class OrderingDonutsController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView<Donut> orderingBasketListView;

    @FXML
    private ComboBox<String> donutTypeComboBox;

    private String[] donutTypes = {"yeast", "cake", "donut holes"};

    private Map<String, Image> donutImages = new HashMap<>();

    @FXML
    private ImageView donutImageView;

    private Donut donut = new Donut();


    /**
     * This initializer method adds the event listeners to make the view more dynamic,
     * adds images, and adds items to the listview
     * @param url Location to resolve relative paths to root object or null
     * @param resourceBundle Resources used to localize the root object or null
     */
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        donutTypeComboBox.getItems().addAll(donutTypes);
        ObservableList<Donut> newList = FXCollections.observableArrayList();
        orderingBasketListView.setItems(newList);

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
    private TextArea orderingBasketTextArea;

    @FXML
    private Button addToOrderButton;

    @FXML
    private Button backToMainViewButton;

    @FXML
    private TextArea donutError;

    /**
     * Helper method to calculate the current price of the order and display it
     */
    private void price(){
        double price = 0.0;
        for (Donut d: orderingBasketListView.getItems()){
            price += d.getPrice();
        }
        DecimalFormat df = new DecimalFormat("#,##0.00");
        subTotalTextField.setText("$" + df.format(price));
    }

    /**
     * Event handler that processes when a user wants to remove a donut order. Displays
     * success message or detects an error and prints it out.
     */
    @FXML
    protected void onRemoveOrder(){
        Donut removedDonut = orderingBasketListView.getSelectionModel().getSelectedItem();
        if (removedDonut == null) {
            donutError.setText("Please select an item to delete!");
            return;
        }
        MainController.removeMenuItem(removedDonut);
        orderingBasketListView.getItems().remove(removedDonut);
        price();
        donutError.setText("Successfully removed donut order!");
    }

    /**
     * Event handler that processes when a user wants to add a donut order. Displays
     * success message or detects error and displays the error message.
     */
    @FXML
    protected void onAddOrder(){
        String selectedType = donutTypeComboBox.getValue();
        if (selectedType == null || selectedType.length() == 0) {
            donutError.setText("Please enter a type of donut!");
            return;
        }
        String selectedFlavor = flavorsListView.getSelectionModel().getSelectedItem();
        if (selectedFlavor == null || selectedFlavor.length() == 0) {
            donutError.setText("Please enter a flavor!");
            return;
        }
        String stringQuantity = quantityTextField.getText();
        int quantity = 0;
        try { quantity = Integer.parseInt(stringQuantity);}
        catch (Exception e){
            donutError.setText("Please enter a valid quantity!");
            return;
        }
        this.donut.setType(selectedType.toUpperCase());
        this.donut.setFlavor(selectedFlavor.toUpperCase());
        this.donut.setQuantity(quantity);

        DecimalFormat df = new DecimalFormat("#,##0.00");
        subTotalTextField.setText("$" + df.format(this.donut.getPrice()));
        MainController.addMenuItem(new Donut(this.donut));
        orderingBasketListView.getItems().add(new Donut(this.donut));
        price();
        donutError.setText("Successfully added donut order!");
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
