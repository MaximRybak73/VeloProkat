package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChangeLogController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField newLogField;

    @FXML
    private Button okPassButton;

    @FXML
    void initialize() {
        assert newLogField != null : "fx:id=\"newLogField\" was not injected: check your FXML file 'changeLog.fxml'.";
        assert okPassButton != null : "fx:id=\"okPassButton\" was not injected: check your FXML file 'changeLog.fxml'.";

    }

}
