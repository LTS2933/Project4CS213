package com.example.project4;
import com.example.project4.model.Donut;
import com.example.project4.model.MenuItem;
import com.example.project4.model.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This is the main controller that contains important methods for the main view
 * and for maintaining orders and order items
 * @author Christian Osma, Liam Smith
 */
public class MainController {

    @FXML
    private Button orderDonutsButton;
    @FXML
    private Button orderCoffeeButton;
    @FXML
    private Button basketButton;
    @FXML
    private Button placedOrdersButton;


    private Stage stage;
    private Scene scene;
    private Parent root;
    public static int id = 1;

    public static ArrayList<Order> orders = new ArrayList<Order>();
    public static ArrayList<MenuItem> currentOrder = new ArrayList<MenuItem>();

    public static ArrayList<Order> getOrders(){
        return orders;
    }

    /**
     * This method adds the inputted order to the orders list
     * @param order Order to be added
     */
    public static void addOrder(Order order){
        order.setOrderNumber(id);
        orders.add(order);
        id++;
    }

    /**
     * This method removes the specific order from the orders list
     * @param order Order to be removed
     */
    public static void removeOrder(Order order){
        orders.remove(order);
    }

    /**
     * Getter method for getting the list of items in the current order
     * @return ArrayList containing the items of the current order
     */
    public static ArrayList<MenuItem> getCurrentOrder(){
        return currentOrder;
    }

    /**
     * This method adds a specific MenuItem to the current order
     * @param item MenuItem to be added to current order
     */
    public static void addMenuItem(MenuItem item){
        currentOrder.add(item);
    }

    /**
     * This method removes the inputted MenuItem from the current order
     * @param item MenuItem to be removed from the current order
     */
    public static void removeMenuItem(MenuItem item){
        currentOrder.remove(item);
    }

    /**
     * This method resets the current order to an empty list
     */
    public static void clearCurrentOrder(){
        currentOrder.clear();
    }

    /**
     * Event handler that changes the view to the OrderingDonutsView when the button to
     * do so is clicked.
     * @throws IOException should there be an issue with directories or input stream.
     */
    @FXML
    protected void showDonutOrderScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("OrderingDonutsView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Event handler that changes the view to the OrderingCoffeeView when the button to
     * do so is clicked.
     * @throws IOException should there be an issue with directories or input stream.
     */
    @FXML
    protected void showCoffeeOrderScreen(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("OrderingCoffeeView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Event handler that changes the view to the OrderingBasketView when the button to
     * do so is clicked.
     * @throws IOException should there be an issue with directories or input stream.
     */
    @FXML
    protected void showOrderingBasketScreen(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("OrderingBasketView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Event handler that changes the view to the StoreOrdersView when the button to
     * do so is clicked.
     * @throws IOException should there be an issue with directories or input stream.
     */
    @FXML
    protected void showStoreOrdersScreen(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("StoreOrdersView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
