package questao05;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplicacao extends Application {

    @FXML private TextField descricao;
    @FXML private TextField valor;
    @FXML private TextField quantidade;
    @FXML private Button calcularBotao;

    @FXML
    public void handleCalcularBotao(ActionEvent event) {
        
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Aplicacao.class.getResource("FXMLQuestao04.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
