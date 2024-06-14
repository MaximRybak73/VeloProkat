package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AfterOrderController extends AuthorizationController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitButton;

    @FXML
    private Button orderMoreButton;

    @FXML
    void initialize() {
        orderMoreButton.setOnAction(event -> {
            openNewScene("app.fxml", orderMoreButton);
        });

        exitButton.setOnAction(event -> {
            openNewScene("authorization.fxml", exitButton);
        });
    }

}
