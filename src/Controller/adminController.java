package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class adminController {


    public AnchorPane centerAdmin;
    public BorderPane borderPane;
    @FXML
        private AnchorPane addAnchorPane;
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
            System.out.println("Employee record");
            topLabel.setAlignment(Pos.CENTER);
            topLabel.setVisible(true);
            topLabel.setText("Employee");

            try {
                Parent root= FXMLLoader.load(getClass().getResource("../view/adminEmployeeTab.fxml"));
                borderPane.setCenter(root);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
       public void stockView(ActionEvent event) {
           changeScene(event,"stock","user");

        }

        public void salesView(ActionEvent event) {
            System.out.println("Sales record");

        }

        public void purchaseView(ActionEvent event) {
            System.out.println("Purchase record");

        }

    private void changeScene(ActionEvent event,String labelToSet,String sceneToSet){
        System.out.println(sceneToSet);
        topLabel.setAlignment(Pos.CENTER);
        topLabel.setVisible(true);
        topLabel.setText(labelToSet);
        System.out.println(sceneToSet);
        try {
            String url="../view/"+ sceneToSet+".fxml";
            Parent root= FXMLLoader.load(getClass().getResource(url));
            borderPane.setCenter(root);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
