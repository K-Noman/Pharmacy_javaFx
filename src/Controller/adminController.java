package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class adminController {


    public JFXButton backButton;
    public BorderPane borderPane;
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
        System.out.println("stock");
        changeScene(event,"stockView");
    }

//    public void purchaseView(ActionEvent event) {
//        System.out.println("Purchase record");
//
//    }

    private void changeScene(ActionEvent event,String sceneToSet){
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
}
