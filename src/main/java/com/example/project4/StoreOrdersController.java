package com.example.project4;

import com.example.project4.model.MenuItem;
import com.example.project4.model.Order;
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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class is responsible to handle events and interactions in the store orders
 * view. Contains methods to remove orders and display the orders in a text file.
 * @author Christian Osma, Liam Smith
 */
public class StoreOrdersController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ListView<Order> ordersDetails;

    @FXML
    private Button cancelButton;

    @FXML
    private Button exportToTextFileButton;

    @FXML
    private Button backToMainViewButton;

    @FXML
    private TextArea ordersError;

    private ArrayList<Order> orders;

    private ObservableList<Order> items;

    /**
     * This method initializes the orders and displays it in the ListView
     * for users to see.
     * @param url Location to resolve relative paths to root object or null
     * @param resourceBundle Resources to localize root object or null
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Order> orders = MainController.getOrders();
        this.orders = orders;
        this.items = FXCollections.observableArrayList();
        for (Order o: orders){
            this.items.add(o);
        }
        ordersDetails.setItems(items);
    }

    /**
     * Event handler that processes when user wants to cancel an order. Displays
     * success message on success or prints error message when no order is selected.
     */
    @FXML
    protected void onCancelOrder(){
        Order order = ordersDetails.getSelectionModel().getSelectedItem();
        if (order == null) {
            ordersError.setText("Please enter an order to remove!");
            return;
        }
        ObservableList<Order> newItems = FXCollections.observableArrayList();
        for (Order i : ordersDetails.getItems()){{
            if (i.equals(order) == false) newItems.add(i);
        }}
        MainController.removeOrder(order);
        ordersDetails.setItems(newItems);
        ordersError.setText("");
    }

    /**
     * Event handler that handles when the user wants to export contents
     * of orders to a file. Prints out the contents of the orders to a specific
     * text file just like how it is show in the GUI.
     */
    @FXML
    protected void onExport(){
        try {File file = new File("orders.txt"); file.createNewFile();}
        catch (IOException e){
            ordersError.setText(e.toString());
            return;
        }
        ObservableList<Order> currentOrders = ordersDetails.getItems();
        try {
            FileWriter writer = new FileWriter("orders.txt");
            for (Order o: currentOrders){
                writer.write(o.toString());
            }
            writer.close();
            ordersError.setText("");
        } catch (IOException e){
            ordersError.setText(e.toString());
        }
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
