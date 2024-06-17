package com.example.demo1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteOrderController extends Helper{

    @FXML
    private Button deleteButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField delete_id_Field;


    @FXML
    void initialize() {
        deleteButton.setOnAction(event -> {
            DataBase db = new DataBase();
            //вызов метода для удаления заказа
            String id_to_delete = delete_id_Field.getText();
            try {
                db.deleteCurrentOrder(id_to_delete);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            openNewScene("adminWindow.fxml", deleteButton);
        });

        exitButton.setOnAction(event -> {
            openNewScene("adminWindow.fxml" ,exitButton);
        });
    }

}
