package com.example.demo1;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeleteOrderController extends Helper{

    @FXML
    private Button deleteButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField delete_id_Field;

    @FXML
    private Label errorLabel;


    @FXML
    void initialize() {
        DataBase db = new DataBase();
        deleteButton.setOnAction(event -> {
            //вызов метода для удаления заказа
            String id_to_delete = delete_id_Field.getText();
            ResultSet result = null;
            try {
                result = db.isBeOrder(id_to_delete);
                int count = 0;
                while (result.next()) {
                    count++;
                }
                if (count == 1) {
                    db.deleteCurrentOrder(id_to_delete);
                    openNewScene("adminWindow.fxml", deleteButton);
                }
                else{
                    errorLabel.setText("Заказ не найден!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        });

        exitButton.setOnAction(event -> {
            openNewScene("adminWindow.fxml" ,exitButton);
        });
    }

}
