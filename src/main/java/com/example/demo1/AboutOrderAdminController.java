package com.example.demo1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AboutOrderAdminController extends  Helper{

    @FXML
    private TextField adressClientField;

    @FXML
    private Button exitButton;

    @FXML
    private TextField modelInOrderFild;

    @FXML
    private TextField nameClientField;

    @FXML
    private TextField numPassField;

    @FXML
    private TextField serPassField;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        DataBase db = new DataBase();
        Client client = db.getClientByOrderId(AdminShowTableController.order_id);

        if(client != null){
            nameClientField.setText(client.getName());
            serPassField.setText(client.getSeries_pass());
            numPassField.setText(client.getNum_pass());
            adressClientField.setText(client.getAdress());
        }

        String model = db.getModelByOrderId(AdminShowTableController.order_id);
        if(model != null){
            modelInOrderFild.setText(model);
        }

        exitButton.setOnAction(event -> {
            openNewScene("adminWindow.fxml", exitButton);
        });

    }

}
