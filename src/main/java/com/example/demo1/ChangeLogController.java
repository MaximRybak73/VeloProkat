package com.example.demo1;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangeLogController extends Helper{

    @FXML
    private TextField newLogField;

    @FXML
    private Button exitButton;

    @FXML
    private Button okLogButton;
    @FXML
    private Label label;

    @FXML
    void initialize() {
        DataBase db = new DataBase();
        okLogButton.setOnAction(event -> {
            String newLogin = newLogField.getText();

            ResultSet result = null;
            try {
                result = db.isBusyLogin(newLogin);
                int count = 0;
                while (result.next()) {
                    count++;
                }
                if (count == 0) {
                    db.updateClientLogin(newLogin, AuthorizationController.password);
                    openNewScene("authorization.fxml", okLogButton);
                }
                else{
                   label.setText(" Пользователь с данным логином уже существует!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        exitButton.setOnAction(event -> {
            openNewScene("app.fxml", exitButton);
        });
    }
}
