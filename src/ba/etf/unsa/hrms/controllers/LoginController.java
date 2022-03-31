package ba.etf.unsa.hrms.controllers;

import ba.etf.unsa.hrms.models.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML private Hyperlink lnkDemoAdmin;
    @FXML private Hyperlink lnkDemoUser;
    @FXML private RadioButton radioAdmin;
    @FXML private RadioButton radioUser;
    @FXML private Button btnLogin;


    public void actionLogin(ActionEvent actionEvent) {
        try {
            DashboardController dashboardController = new DashboardController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dashboard.fxml"));
            loader.setController(dashboardController);
            loader.load();
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.close();
            stage.setScene(new Scene(loader.getRoot(), 800, 400));
            stage.setMinHeight(425);
            stage.setMinWidth(800);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
