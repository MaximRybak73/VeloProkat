package com.example.demo1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adressField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField seriesPassField;

    @FXML
    private TextField numPassField;

    @FXML
    private TextField passwordField;

    @FXML
    private Button sugnUpButton;

    @FXML
    void initialize() {
        DataBase db = new DataBase();
        sugnUpButton.setOnAction(event -> {
            try {
                db.writeClientInDB(nameField.getText(), seriesPassField.getText(), numPassField.getText(), adressField.getText(), loginField.getText(), passwordField.getText());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });


    }

}
