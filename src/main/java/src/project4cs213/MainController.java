package src.project4cs213;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

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

    @FXML
    protected void showDonutOrderScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("OrderingDonutsView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void showCoffeeOrderScreen(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("OrderingCoffeeView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void showOrderingBasketScreen(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("OrderingBasketView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void showStoreOrdersScreen(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("StoreOrdersView.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}