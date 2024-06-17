package com.example.demo1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChangePassController extends Helper{

    @FXML
    private TextField newPassField;

    @FXML
    private Button okPassButton;

    @FXML
    private Button exitButton;

    @FXML
    void initialize() {
        okPassButton.setOnAction(event -> {
            DataBase dataBase = new DataBase();
            String newPass = newPassField.getText();
            try {
                dataBase.updateClientPassword(AuthorizationController.login, newPass);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            openNewScene("authorization.fxml", okPassButton);
        });

        exitButton.setOnAction(event -> {
            openNewScene("app.fxml", exitButton);
        });


    }

}
