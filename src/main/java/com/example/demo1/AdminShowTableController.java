package com.example.demo1;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminShowTableController extends Helper {

    @FXML
    private TableColumn<Order, String> bike_idColumn;

    @FXML
    private TableColumn<Order, String> client_idColumn;

    @FXML
    private Button deleteOrderButton;

    @FXML
    private TableColumn<Order, String> give_dateColumn;

    @FXML
    private Button aboutOrderButton;

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<Order, String> order_idColumn;

    @FXML
    private TableColumn<Order, String> return_dateColumn;

    @FXML
    private TableColumn<Order, String> shop_nameColumn;


    @FXML
    private TextField orderIdAbout_Field;

    @FXML
    public TableView<Order> tableView;

    public static String order_id;

    @FXML
    void initialize() {
        AtomicInteger countr = new AtomicInteger();

        DataBase db = new DataBase();
        try {
            if(countr.get() == 0)
                db.loadOrdersFromDB(tableView);
            countr.set(1);
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

        deleteOrderButton.setOnAction(event -> {
            openNewScene("deleteOrderAdmin.fxml", deleteOrderButton);
            countr.set(0);
        });

        aboutOrderButton.setOnAction(event -> {
            order_id = orderIdAbout_Field.getText();
            openNewScene("aboutOrderAdmin.fxml", aboutOrderButton);
        });

        exitButton.setOnAction(event -> {
            openNewScene("authorization.fxml", exitButton);
        });


    }
}