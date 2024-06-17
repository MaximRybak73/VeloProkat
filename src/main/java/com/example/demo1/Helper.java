package com.example.demo1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Helper {
    public void openNewScene(String window, Button button) {
        button.getScene().getWindow().hide();  //getScene()  -взять сцену на которой нах-ся эта кнопка, получить окно, hide() - спрятать
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window)); //setLocation() - указать месторасположение нужного файла

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();  //полный путь к файлу который необходимо загрузить
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.show(); //показать и подождать пока что-то отобразиться
    }
}
