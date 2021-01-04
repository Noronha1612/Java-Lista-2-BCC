package questao05;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import questao05.Classes.Produto;

import java.io.IOException;

public class Aplicacao extends Application {

    @FXML private TextField descricao;
    @FXML private TextField valor;
    @FXML private TextField quantidade;
    @FXML private Button calcularBotao;

    @FXML
    public void handleCalcularBotao(ActionEvent event) {
        if ( !valor.getText().matches("[+-]?([0-9]*[,])?[0-9]+") || !quantidade.getText().matches("[0-9]*") ) {
            Alert typeError = new Alert(Alert.AlertType.WARNING);

            typeError.setHeaderText(null);
            typeError.setTitle("Aviso!");
            typeError.setContentText("Os campos Valor e Quantidade devem ser númericos");
            typeError.show();

            return;
        }

        String errorField = "";

        if ( descricao.getText().trim().isEmpty() )
            errorField = "Descrição do produto";
        else if ( valor.getText().trim().isEmpty() )
            errorField = "Valor R$";
        else if ( quantidade.getText().trim().isEmpty() )
            errorField = "Quantidade";

        if ( descricao.getText().trim().isEmpty() ||
                valor.getText().trim().isEmpty() ||
                quantidade.getText().trim().isEmpty()
        )
        {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Erro!");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText(String.format("Favor, informe o campo %s", errorField));
            errorAlert.show();

            return;
        }

        Produto produto = new Produto(
                Double.parseDouble(valor.getText().replace(',', '.')),
                Integer.parseInt(quantidade.getText()),
                descricao.getText()
        );

        Alert calculeMessage = new Alert(Alert.AlertType.INFORMATION);
        calculeMessage.setTitle("Mensagem");
        calculeMessage.setHeaderText(null);
        calculeMessage.setContentText(String.format("O valor calculado para a venda do produto %s é R$ %.2f", produto.getDescricao(), produto.calcularTotal()));
        calculeMessage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Aplicacao.class.getResource("Aplicacao.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
