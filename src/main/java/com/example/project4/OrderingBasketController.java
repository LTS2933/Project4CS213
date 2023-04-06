package com.example.project4;

import com.example.project4.MainController;
import com.example.project4.model.MenuItem;
import com.example.project4.model.Order;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class is responsible for handling events in the ordering basket view
 * and contains methods for adding and removing items and placing orders
 * @author Christian Osma, Liam Smith
 */
public class OrderingBasketController implements Initializable {

    public static final double SALES_TAX = 0.0625;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private ListView<MenuItem> ordersListView;

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
    private TextArea orderError;

    private ObservableList<MenuItem> items;
    private Order order;

    /**
     * This helper method is responsible for calculating the current price of the
     * order and displaying it on screen
     */
    private void calculatePrice(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        subTotalTextField.setText("$" + df.format(this.order.getPrice()));
        salesTaxTextField.setText("$" + df.format(this.order.getPrice() * SALES_TAX));
        totalTextField.setText("$" + df.format(this.order.getPrice() + (this.order.getPrice() * SALES_TAX)));
    }

    /**
     * This method initializes the list of menu items to the items inputted by the user
     * in other views and displaying it on screen
     * @param url Location used to resolve relative paths for root object or null
     * @param resourceBundle Resources used to localize root object or null
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<MenuItem> order = MainController.getCurrentOrder();
        items = FXCollections.observableArrayList();
        for (MenuItem o : order){
            items.add(o);
        }
        ordersListView.setItems(items);

        this.order = new Order(order);
        calculatePrice();
    }

    /**
     * Event handler that processes when a user wants to place an order. Calls the main
     * controller to add the current order to order list and displays success message.
     */
    @FXML
    protected void onPlaceOrder(){
        MainController.addOrder(new Order(this.order));
        this.order.setMenuItems(new ArrayList<MenuItem>());
        this.items = FXCollections.observableArrayList();
        ordersListView.setItems(this.items);
        MainController.clearCurrentOrder();
        orderError.setText("Successfully placed order");
    }

    /**
     * Event handler for processing when the user wants to cancel an order. Displays
     * a success message or error message with specific details.
     */
    @FXML
    protected void onCancelOrder(){
        MenuItem item = ordersListView.getSelectionModel().getSelectedItem();
        if (item == null) {
            orderError.setText("Please enter a item to remove!");
            return;
        }
        ObservableList<MenuItem> newItems = FXCollections.observableArrayList();
        for (MenuItem i : ordersListView.getItems()){{
            if (i.equals(item) == false) newItems.add(i);
        }}
        MainController.removeMenuItem(item);
        ordersListView.setItems(newItems);
        calculatePrice();
        orderError.setText("Successfully cancelled order!");
    }
    /**
     * Event handler that changes the view to the MainView when the button to
     * do so is clicked.
     * @throws IOException should there be an issue with directories or input stream.
     */
    @FXML
    protected void showMainViewScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
