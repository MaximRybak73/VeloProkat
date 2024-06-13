package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField giveDateField;

    @FXML
    private ComboBox<?> modelSpis;

    @FXML
    private Button orderButton;

    @FXML
    private TextField returnDateField;

    @FXML
    private ComboBox<?> shopSpis;

    @FXML
    void initialize() {

    }

}
