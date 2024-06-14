package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChangePassController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField newPassField;

    @FXML
    private Button passOkButton;

    @FXML
    void initialize() {
        assert newPassField != null : "fx:id=\"newPassField\" was not injected: check your FXML file 'changePassword.fxml'.";
        assert passOkButton != null : "fx:id=\"passOkButton\" was not injected: check your FXML file 'changePassword.fxml'.";

    }

}
