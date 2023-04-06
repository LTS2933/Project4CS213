package com.example.project4;

import com.example.project4.MainController;
import com.example.project4.model.Coffee;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.MapChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class is responsible for handling events and interactions in the ordering basket
 * view. Contains methods to help the user add a coffee order to their current order.
 * @author Christian Osma, Liam Smith
 */
public class OrderingCoffeeController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ToggleGroup sizeToggleGroup;

    @FXML
    private TextField numberOfCupsTextField;

    @FXML
    private TextField subTotal;

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
    private TextArea coffeeError;

    private Coffee coffee = new Coffee();
    private List<String> addOns = new ArrayList<String>();

    /**
     * This method is called to initialize the event listeners to listen to specific
     * actions by the user and calls a helper method
     * @param url Location used to resolve relative paths for root object
     * @param resourceBundle The resources used to localize the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numberOfCupsTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            onChangeQuantity();
        });
        sizeToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                onChangeQuantity();
            }
        });
        sweetCreamCheckBox.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    onChangeQuantity();
                });
        frenchVanillaCheckBox.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    onChangeQuantity();
                });
        irishCreamCheckBox.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    onChangeQuantity();
                });
        caramelCheckBox.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    onChangeQuantity();
                });
        mochaCheckBox.selectedProperty().addListener(
                (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    onChangeQuantity();
                });
    }

    /**
     * Helper method that calculates the new price of the coffee order and displays it
     */
    private void onChangeQuantity(){
        String stringQuantity = numberOfCupsTextField.getText();
        if (sizeToggleGroup.getSelectedToggle() == null) {
            //coffeeError.setText("Please enter a size!");
            return;
        }
        String size = sizeToggleGroup.getSelectedToggle().getUserData().toString();
        int quantity = 0;
        try {
            quantity = Integer.parseInt(stringQuantity);
        } catch (Exception e){
            //coffeeError.setText("Please enter a valid quantity!");
            return;
        }
        if (quantity > 5 || quantity <= 0) {
            //coffeeError.setText("Please enter a quantity between 1-5!");
            return;
        }

        if (sweetCreamCheckBox.isSelected()) this.addOns.add("SWEET CREAM");
        if (frenchVanillaCheckBox.isSelected()) this.addOns.add("FRENCH VANILLA");
        if (irishCreamCheckBox.isSelected()) this.addOns.add("IRISH CREAM");
        if (caramelCheckBox.isSelected()) this.addOns.add("CARAMEL");
        if (mochaCheckBox.isSelected()) this.addOns.add("MOCHA");

        coffee.setQuantity(quantity);
        coffee.setSize(size);
        coffee.setToppings(this.addOns);

        DecimalFormat df = new DecimalFormat("#,##0.00");
        double price = coffee.getPrice();
        subTotal.setText("$" + df.format(price));
        coffee.clearToppings();
        coffeeError.setText("");
    }

    /**
     * Helper method that clears the parameters to default values and resets the order
     */
    private void clear(){
        sizeToggleGroup.selectToggle(null);
        numberOfCupsTextField.setText("");
        sweetCreamCheckBox.setSelected(false);
        frenchVanillaCheckBox.setSelected(false);
        irishCreamCheckBox.setSelected(false);
        caramelCheckBox.setSelected(false);
        mochaCheckBox.setSelected(false);
        subTotal.setText("$0.00");
    }

    /**
     * Event handler that processes when a user wants to add a coffee to the order. Displays
     * success message or detects error and prints it out.
     */
    @FXML
    protected void onAddCoffee(){
        if (sizeToggleGroup.getSelectedToggle() == null) {
            coffeeError.setText("Please enter a size!");
            return;
        }
        String size = sizeToggleGroup.getSelectedToggle().getUserData().toString();
        String stringQuantity = numberOfCupsTextField.getText();
        int quantity = 0;
        try { quantity = Integer.parseInt(stringQuantity); }
        catch (Exception e) {
            coffeeError.setText("Please enter a valid quantity!");
            return;
        }
        if (quantity > 5 || quantity <= 0) {
            coffeeError.setText("Please enter a quantity between 1-5!");
            return;
        }
        if (sweetCreamCheckBox.isSelected()) this.addOns.add("SWEET CREAM");
        if (frenchVanillaCheckBox.isSelected()) this.addOns.add("FRENCH VANILLA");
        if (irishCreamCheckBox.isSelected()) this.addOns.add("IRISH CREAM");
        if (caramelCheckBox.isSelected()) this.addOns.add("CARAMEL");
        if (mochaCheckBox.isSelected()) this.addOns.add("MOCHA");

        coffee.setSize(size);
        coffee.setQuantity(quantity);
        List<String> copy = new ArrayList<String>();
        for (String item : this.addOns){copy.add(item);}
        coffee.setToppings(copy);

        DecimalFormat df = new DecimalFormat("#,##0.00");
        double price = coffee.getPrice();
        subTotal.setText("$" + df.format(price));
        MainController.addMenuItem(new Coffee(coffee));
        this.addOns.clear();
        coffeeError.setText("Successfully added coffee!");
        clear();
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
