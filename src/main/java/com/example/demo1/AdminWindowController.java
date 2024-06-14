package com.example.demo1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class AdminWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> bike_id;

    @FXML
    private TableColumn<?, ?> client_id;

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
        assert bike_id != null : "fx:id=\"bike_id\" was not injected: check your FXML file 'adminWindow.fxml'.";
        assert client_id != null : "fx:id=\"client_id\" was not injected: check your FXML file 'adminWindow.fxml'.";
        assert give_date != null : "fx:id=\"give_date\" was not injected: check your FXML file 'adminWindow.fxml'.";
        assert order_id != null : "fx:id=\"order_id\" was not injected: check your FXML file 'adminWindow.fxml'.";
        assert return_date != null : "fx:id=\"return_date\" was not injected: check your FXML file 'adminWindow.fxml'.";
        assert shop_name != null : "fx:id=\"shop_name\" was not injected: check your FXML file 'adminWindow.fxml'.";

    }

}
