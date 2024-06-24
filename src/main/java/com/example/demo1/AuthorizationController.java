package com.example.demo1;
import java.sql.ResultSet;
import java.sql.SQLException;
import Animations.Shake;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AuthorizationController extends Helper{

    @FXML
    private TextField PasswordField;

    @FXML
    private Button enterButton;

    @FXML
    private TextField loginField;

    @FXML
    private Button registrationButton;
    public static String login;
    public static String password;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        enterButton.setOnAction(event -> {
            login = loginField.getText().trim();
            password = PasswordField.getText().trim();


            if (!login.equals("") && !password.equals("")) {
                try {
                    loginClient(login, password);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Login/password is empty");
            }
        });

        registrationButton.setOnAction(event -> {
            openNewScene("signUp.fxml", registrationButton);
        });
    }

    private void loginClient(String login, String password) throws SQLException, ClassNotFoundException {
        DataBase dataBase = new DataBase();
        Client client = new Client();

        client.setLogin(login);
        client.setPassword(password);

        ResultSet result = dataBase.getClient(client);

        int count = 0;
        while (result.next()) {
            count++;
        }

        if(dataBase.isAdmin(login)){
            openNewScene("adminWindow.fxml", enterButton);
            return;
        }

        if (count >= 1) {
            openNewScene("app.fxml", enterButton);
        } else {

            Shake clientLogAnim = new Shake(loginField);
            Shake clientPassAnim = new Shake(PasswordField);
            clientLogAnim.playAnim();
            clientPassAnim.playAnim();
        }
    }
}





