package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class
dashBoardController {


    public Label main_heading;


    public void cons_bt_ac(ActionEvent event) {

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

    public void hist_bt_ac(ActionEvent event) {
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

        changeScene();

    }

    public void AddPurchaseAction(ActionEvent event) {


    }

    public void AddCompanyAction(ActionEvent event) {

    }

    public void ViewEmployeeAction(ActionEvent event) {

    }

    public void ViewPurchaseAction(ActionEvent event) {

    }

    public void ViewSalesAction(ActionEvent event) {

    }






    private void changeScene(){


        try {
                Parent root= FXMLLoader.load(getClass().getResource("../View/admin.fxml"));
                Stage stage=(Stage)main_heading.getScene().getWindow();
                javafx.scene.Scene scene=new javafx.scene.Scene(root);
                stage.setScene(scene);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
