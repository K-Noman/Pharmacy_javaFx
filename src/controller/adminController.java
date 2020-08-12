package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class adminController {


    public JFXButton backButton;
    public  BorderPane borderPane;
    public MenuItem employeeView;
    public MenuItem salesView;
    public MenuItem stockView;
    public Label label;


    public void backButtonAction(ActionEvent event) {
        System.out.println("backButtonAction");
        try {
            Parent root= FXMLLoader.load(getClass().getResource("../View/mainView.fxml"));
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
        System.out.println("emp");
        changeScene(event,"empView");



    }
    public void salesView(ActionEvent event) {
        System.out.println("Sales record");
        changeScene(event,"salesView");
    }
    public void stockView(ActionEvent event) {
        System.out.println("Classes.stock");
        changeScene(event,"stockView");
    }



    public void changeScene(ActionEvent event,String sceneToSet){
        System.out.println(sceneToSet);

        try {
//            Stage stage=(Stage)label.getScene().getWindow();
            String url="/view/"+ sceneToSet+".fxml";
            Parent root= FXMLLoader.load(getClass().getResource(url));
            borderPane.setAlignment(root,Pos.CENTER);
            borderPane.setCenter(root);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void newEmployee(ActionEvent event) {
        changeScene(event,"addNew/empAdd");
    }

    public void newPurchase(ActionEvent event) {
        changeScene(event,"addNew/purchaseAdd");
    }
    public void newCompany(ActionEvent event) {
        changeScene(event,"addNew/companyAdd");
    }



    public void cons_bt_mi(MouseEvent mouseEvent) {

    }

    public void cons_bt_mo(MouseEvent mouseEvent) {

    }

    public void tax_bt_ac(ActionEvent event) {

    }

    public void tax_bt_mi(MouseEvent mouseEvent) {
    }

    public void tax_bt_mo(MouseEvent mouseEvent) {

    }

    public void hist_bt_mi(MouseEvent mouseEvent) {

    }

    public void hist_bt_mo(MouseEvent mouseEvent) {

    }

    public void bill_bt_mi(MouseEvent mouseEvent) {

    }

    public void bill_bt_mo(MouseEvent mouseEvent) {

    }

    public void AddEmployeeAction(ActionEvent event) {
        changeScene(event,"addNew/empAdd");


    }

    public void AddPurchaseAction(ActionEvent event) {
        changeScene(event,"addNew/purchaseAdd");


    }

    public void AddCompanyAction(ActionEvent event) {
        changeScene(event,"addNew/companyAdd");

    }

    public void ViewEmployeeAction(ActionEvent event) {
        System.out.println("emp");
        changeScene(event,"empView");
    }

    public void ViewPurchaseAction(ActionEvent event) {
        System.out.println("Sales record");
        changeScene(event,"salesView");

    }

    public void ViewSalesAction(ActionEvent event) {
        System.out.println("Classes.stock");
        changeScene(event,"stockView");

    }


}
