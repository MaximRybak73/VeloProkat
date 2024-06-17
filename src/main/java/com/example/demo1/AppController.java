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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController extends Helper{

    @FXML
    private TextField giveDateField;

    @FXML
    private Button changeLogButton;

    @FXML
    private Button changePassButton;

    @FXML
    private ComboBox<String> modelSpis;

    @FXML
    private Button orderButton;

    @FXML
    private Button exitButton;


    @FXML
    private Button aboutModelsButton;

    @FXML
    private TextField returnDateField;

    @FXML
    private Label label;

    @FXML
    private ComboBox<String> shopSpis;

    @FXML
    void initialize() {
        aboutModelsButton.setOnAction(event -> {
            openNewScene("aboutModels.fxml", aboutModelsButton);
        });

        exitButton.setOnAction(event -> {
            openNewScene("authorization.fxml", exitButton);
        });

        changeLogButton.setOnAction(event -> {
            openNewScene("changeLog.fxml", changeLogButton);
        });

        changePassButton.setOnAction(event -> {
            openNewScene("changePassword.fxml", changePassButton);
        });

        modelSpis.setOnShowing(event -> {
            DataBase dataBase = new DataBase();
            try {
                populateModelSpis(dataBase);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        });

        shopSpis.setOnShowing(event -> {
            DataBase db = new DataBase();
            try {
                populateShopSpis(db);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        });

        orderButton.setOnAction(event -> {
            DataBase db = new DataBase();

            Client client = new Client();
            client.setLogin(AuthorizationController.login);
            client.setPassword(AuthorizationController.password);

            try {
                String selectedModel = modelSpis.getSelectionModel().getSelectedItem();
                String selectedShop = shopSpis.getSelectionModel().getSelectedItem();

                ResultSet freeBikeResultSet = db.getFreeBike(selectedModel);
                if (freeBikeResultSet.next()) {
                    String bike_id = freeBikeResultSet.getString(Constants.BIKE_BIKE_ID);

                    ResultSet clientResultSet = db.getClient(client);
                    if (clientResultSet.next()) {
                        String client_id = clientResultSet.getString(Constants.CLIENT_ID);

                        String give_date = giveDateField.getText();
                        String return_date = returnDateField.getText();

                        if (!give_date.isEmpty() && !return_date.isEmpty() && selectedModel != null && selectedShop != null) {

                            Order order = new Order(client_id, bike_id, selectedShop, give_date, return_date);
                            db.writeOrderInDB(order);

                            openNewScene("afterOrder.fxml", orderButton);
                        }
                        else{
                            label.setText("Заполните все поля!");
                        }
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
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

    private void populateShopSpis(DataBase dataBase) throws SQLException, ClassNotFoundException {
        ResultSet result = dataBase.getShops();
        ObservableList<String> shops = FXCollections.observableArrayList();
        while (result.next()){
            shops.add(result.getString(Constants.SHOP_SHOP_NAME));
        }

        shopSpis.setItems(shops);
    }



}
