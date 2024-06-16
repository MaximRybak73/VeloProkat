package com.example.demo1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminShowTableController extends AuthorizationController {

    @FXML
    private TableColumn<Order, String> bike_idColumn;

    @FXML
    private TableColumn<Order, String> client_idColumn;

    @FXML
    private Button deleteOrderButton;

    @FXML
    private TableColumn<Order, String> give_dateColumn;

    @FXML
    private Button loadTableButton;

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<Order, String> order_idColumn;

    @FXML
    private TableColumn<Order, String> return_dateColumn;

    @FXML
    private TableColumn<Order, String> shop_nameColumn;

    @FXML
    public TableView<Order> tableView;

    @FXML
    void initialize() {
        deleteOrderButton.setOnAction(event -> {
            openNewScene("deleteOrderAdmin.fxml", deleteOrderButton);
        });

        loadTableButton.setOnAction(event -> {
            DataBase db = new DataBase();
            try {
                db.loadOrdersFromDB(tableView);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            order_idColumn.setCellValueFactory(new PropertyValueFactory<>("order_id"));
            client_idColumn.setCellValueFactory(new PropertyValueFactory<>("client_id"));
            bike_idColumn.setCellValueFactory(new PropertyValueFactory<>("bike_id"));
            shop_nameColumn.setCellValueFactory(new PropertyValueFactory<>("shop_name"));
            give_dateColumn.setCellValueFactory(new PropertyValueFactory<>("give_date"));
            return_dateColumn.setCellValueFactory(new PropertyValueFactory<>("return_date"));
        });
        exitButton.setOnAction(event -> {
            openNewScene("authorization.fxml", exitButton);
        });


    }
}