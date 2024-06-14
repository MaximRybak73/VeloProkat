package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class AdminShowTableController extends AuthorizationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> bike_id;

    @FXML
    private TableColumn<?, ?> client_id;

    @FXML
    private Button deleteOrderButton;

    @FXML
    private TableColumn<?, ?> give_date;

    @FXML
    private TableColumn<?, ?> order_id;

    @FXML
    private TableColumn<?, ?> return_date;

    @FXML
    private TableColumn<?, ?> shop_name;

    @FXML
    void initialize() {
        deleteOrderButton.setOnAction(event -> {
            openNewScene("deleteOrderAdmin.fxml", deleteOrderButton);
        });

    }
}