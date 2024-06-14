package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DeleteOrderController extends AuthorizationController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button deleteButton;

    @FXML
    void initialize() {
        deleteButton.setOnAction(event -> {
            //вызов метода для удаления заказа
            openNewScene("adminWindow.fxml", deleteButton);
        });



    }

}
