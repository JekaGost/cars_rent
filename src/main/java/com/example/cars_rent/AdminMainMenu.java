package com.example.cars_rent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminMainMenu {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RegisterPage.class.getResource("admin-main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 880, 900);
        stage.setTitle("Admin Anasayfası");
        stage.setScene(scene);
        stage.show();
    }
}
