package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AboutModelsController extends Helper{

    @FXML
    private Button exitButton;

    @FXML
    void initialize() {
        exitButton.setOnAction(event -> {
            openNewScene("app.fxml", exitButton);
        });
    }

}
