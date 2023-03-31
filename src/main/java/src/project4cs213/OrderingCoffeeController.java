package src.project4cs213;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class OrderingCoffeeController {

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
}
