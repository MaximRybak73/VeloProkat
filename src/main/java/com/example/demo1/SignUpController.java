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
        sugnUpButton.setOnAction(event -> {

            signUpNewUser();

        });


    }

    private void signUpNewUser() {
        DataBase db = new DataBase();

        String name = nameField.getText();
        String series_pass = seriesPassField.getText();
        String num_pass = numPassField.getText();
        String adress = adressField.getText();
        String login = loginField.getText();
        String password = passwordField.getText();

        Client client = new Client(name, series_pass, num_pass, adress, login, password);

        try {
            db.writeClientInDB(client);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
