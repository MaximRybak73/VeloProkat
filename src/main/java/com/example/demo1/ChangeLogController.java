package com.example.demo1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChangeLogController extends AuthorizationController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField newLogField;

    @FXML
    private Button exitButton;

    @FXML
    private Button okLogButton;

    @FXML
    void initialize() {
        okLogButton.setOnAction(event -> {
            DataBase db = new DataBase();
            String newLogin = newLogField.getText();
            try {
                db.updateClientLogin(newLogin, AuthorizationController.password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            openNewScene("authorization.fxml", okLogButton);
        });

        exitButton.setOnAction(event -> {
            openNewScene("app.fxml", exitButton);
        });


    }

}
