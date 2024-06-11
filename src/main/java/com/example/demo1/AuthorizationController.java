package com.example.demo1;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuthorizationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField PasswordField;

    @FXML
    private Button enterButton;

    @FXML
    private TextField loginField;

    @FXML
    private Button registrationButton;

    @FXML
    void initialize() {
        enterButton.setOnAction(event -> {
            String login = loginField.getText().trim();
            String password = PasswordField.getText().trim();

            if (!login.equals("") && !password.equals("")) {
                try {
                    loginClient(login, password);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                System.out.println("Login/password is empty");
            }
        });

        registrationButton.setOnAction(event -> {
            registrationButton.getScene().getWindow().hide();  //getScene()  -взять сцену на которой нах-ся эта кнопка, получить окно, hide() - спрятать
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("signUp.fxml")); //setLocation() - указать месторасположение нужного файла

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();  //полный путь к файлу который необходимо загрузить
            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.showAndWait(); //показать и подождать пока что-то отобразиться
        });
    }

    private void loginClient(String login, String password) throws SQLException, ClassNotFoundException {
        DataBase dataBase = new DataBase();
        Client client = new Client();

        client.setLogin(login);
        client.setPassword(password);

        ResultSet result = dataBase.getClient(client);

        int count = 0;
        while(result.next()){
            count++;
        }

        if(count >= 1){
            System.out.println("Успешно!");
        }
        else
            System.out.println("Зарегистрируйтесь!");
    }







//            Parent root = null;
//            try {
//                root = (Parent) FXMLLoader.load((URL) Objects.requireNonNull(this.getClass().getResource("signUp.fxml")));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
////            Scene scene = new Scene(root);
////            stage.setScene(scene);
////            stage.show();
//
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.showAndWait(); //показать и подождать пока что-то отобразиться
////




}


