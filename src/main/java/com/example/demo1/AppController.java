package com.example.demo1;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AppController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField giveDateField;

    @FXML
    private ComboBox<String> modelSpis;

    @FXML
    private Button orderButton;

    @FXML
    private TextField returnDateField;

    @FXML
    private ComboBox<?> shopSpis;

    @FXML
    void initialize() {
        DataBase dataBase = new DataBase();
        modelSpis.setOnShowing(event -> {
            try {
                populateModelSpis(dataBase);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        });



    }

    private void populateModelSpis(DataBase dataBase) throws SQLException, ClassNotFoundException {
        ResultSet result = dataBase.getModels();
        ObservableList<String> models = FXCollections.observableArrayList();
        while (result.next()){
            models.add(result.getString(Constants.BIKE_MODEL_MODEL_NAME));
        }

        modelSpis.setItems(models);
    }

}
