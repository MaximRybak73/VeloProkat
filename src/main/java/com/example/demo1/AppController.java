package com.example.demo1;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private Label labelIncorrectDate;

    @FXML
    private ComboBox<String> shopSpis;

    private String model_name;
    private String shop_name;

    @FXML
    void initialize() {
        DataBase dataBase = new DataBase();
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
            try {
                populateModelSpis(dataBase);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });

        shopSpis.setOnShowing(event -> {
            try {
                populateShopSpis(dataBase);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        });

        orderButton.setOnAction(event -> {
            Client client = new Client();
            client.setLogin(AuthorizationController.login);
            client.setPassword(AuthorizationController.password);

            try {
                ResultSet freeBikeResultSet = dataBase.getFreeBike(model_name);
                if (freeBikeResultSet.next()) {
                    String bike_id = freeBikeResultSet.getString(Constants.BIKE_BIKE_ID);

                    ResultSet clientResultSet = dataBase.getClient(client);
                    if (clientResultSet.next()) {
                        String client_id = clientResultSet.getString(Constants.CLIENT_ID);

                        String give_date = giveDateField.getText();
                        String return_date = returnDateField.getText();

                        if (!give_date.isEmpty() && !return_date.isEmpty() && model_name != null && shop_name != null) {
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                            LocalDate giveDate = LocalDate.parse(give_date, format);
                            LocalDate returnDate = LocalDate.parse(return_date, format);
                            LocalDate currentDate = LocalDate.now();
                            if(giveDate.isBefore(currentDate) || returnDate.isBefore(currentDate)){
                                labelIncorrectDate.setText("Укажите корректные даты!");
                                return;
                            }

                            Order order = new Order(client_id, bike_id, shop_name, give_date, return_date);
                            dataBase.writeOrderInDB(order);

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
            model_name = result.getString(Constants.BIKE_MODEL_MODEL_NAME);
            String model_type = result.getString(Constants.BIKE_MODEL_TYPE);
            String model_count_gear = result.getString(Constants.BIKE_MODEL_COUNT_GEAR);

            String str = model_name + ", Тип: " + model_type + ", " + model_count_gear + " передач";
            models.add(str);
        }
        modelSpis.setItems(models);
    }

    private void populateShopSpis(DataBase dataBase) throws SQLException, ClassNotFoundException {
        ResultSet result = dataBase.getShops();
        ObservableList<String> shops = FXCollections.observableArrayList();
        while (result.next()){
            shop_name = result.getString(Constants.SHOP_SHOP_NAME);
            String shop_adress = result.getString(Constants.SHOP_SHOP_ADRESS);

            String str = "'" + shop_name +"', " + shop_adress;
            shops.add(str);
        }
        shopSpis.setItems(shops);
    }
}
