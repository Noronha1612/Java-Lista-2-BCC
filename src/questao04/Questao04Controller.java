package questao04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Questao04Controller implements Initializable {

    @FXML
    private Button buttonText;

    @FXML
    private Label labelText;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        labelText.setText("Clicou!");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Todo
    }
}
