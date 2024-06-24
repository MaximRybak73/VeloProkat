package com.example.demo1;
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
