package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class
adminController {

    @FXML
    public Label topLabel;
    @FXML
    private MenuItem Employee;
    @FXML
    private Button backButton;

    public void initialize(){
        topLabel.setVisible(false);

    }


    public void backButtonAction(ActionEvent event) {
        System.out.println("backButtonAction");
        try {
            Parent root= FXMLLoader.load(getClass().getResource("../View/mainLogin.fxml"));
            Stage stage=(Stage)backButton.getScene().getWindow();
            javafx.scene.Scene scene=new javafx.scene.Scene(root);
            stage.setScene(scene);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void backButtonAdminClicked(MouseEvent mouseEvent) {
        System.out.println("backButtonAdminClicked");


    }

    public void employeeView(ActionEvent event) {
        topLabel.setAlignment(Pos.CENTER);
        topLabel.setVisible(true);
        topLabel.setText("Employee record");
        System.out.println("Employee record");


    }

    public void stockView(ActionEvent event) {
        System.out.println("Stock record");

    }

    public void salesView(ActionEvent event) {
        System.out.println("Sales record");

    }

    public void purchaseView(ActionEvent event) {
        System.out.println("Purchase record");

    }
}
