package questao04;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Questao04Controller implements Initializable {

    @FXML private Button countButton;
    @FXML private TextArea textArea;
    @FXML private Label labelToShow;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        int countChar = 0;

        String textTyped = textArea.getText();

        for ( int cIndex = 0; cIndex < textTyped.trim().length(); cIndex++ ) {
            if ( textTyped.trim().charAt(cIndex) != ' ' ) countChar++;
        }

        labelToShow.setText(String.format("O texto tem %d characteres", countChar));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Todo
    }
}
