package com.example.demo1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignUpController extends  AuthorizationController{

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
            openNewScene("authorization.fxml", sugnUpButton);
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

        if (!name.isEmpty() && !series_pass.isEmpty() && !num_pass.isEmpty() && !adress.isEmpty() && !login.isEmpty() && !password.isEmpty()) {
            Client client = new Client(name, series_pass, num_pass, adress, login, password);

            try {
                db.writeClientInDB(client);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            if (name.isEmpty()) {
                Shake clientNameAnim = new Shake(nameField);
                clientNameAnim.playAnim();
            }
            if (series_pass.isEmpty()) {
                Shake clientSerPassAnim = new Shake(seriesPassField);
                clientSerPassAnim.playAnim();
            }
            if (num_pass.isEmpty()) {
                Shake clientNumPassAnim = new Shake(numPassField);
                clientNumPassAnim.playAnim();
            }
            if (adress.isEmpty()){
                Shake clientAdressAnim = new Shake(adressField);
                clientAdressAnim.playAnim();
            }
            if (login.isEmpty()){
                Shake clientLoginAnim = new Shake(loginField);
                clientLoginAnim.playAnim();
            }
            if (password.isEmpty()){
                Shake clientPasswordAnim = new Shake(passwordField);
                clientPasswordAnim.playAnim();
            }
        }
    }
}