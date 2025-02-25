package com.example.cars_rent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;



public class LoginPageController {

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button login_anasayfa_button;

    private UserService userService = new UserService();

    @FXML
    private void onLoginClick() throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();


        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Hata", "Alanlar boş bırakılmamalıdır.");
            return;
        }

        boolean isLoginSuccessful = userService.loginUser(username, password);

        if (isLoginSuccessful) {
            showAlert(Alert.AlertType.INFORMATION, "Başarı", "Başarılı bir şekilde giriş yaptınız.");

            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    UserSession.isAdmin() ? "admin-main-menu.fxml" : "main-menu.fxml"
            ));

            Scene nextScene = new Scene(loader.load(), 940, 900);
            Stage stage = (Stage) Stage.getWindows().filtered(window -> window.isShowing()).get(0);
            stage.setScene(nextScene);

            Stage.getWindows().getLast().hide();

        } else {
            showAlert(Alert.AlertType.ERROR, "Hata", "Geçersiz kullanıcı adı veya şifre.");
        }
    }

    @FXML
    private void onLoginAnasayfaButton() {
        Stage stage = (Stage) login_anasayfa_button.getScene().getWindow();
        stage.close();
    }

    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.setOnCloseRequest(_ -> alert.close());
        alert.showAndWait();
        }
    }
