package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

public class userController {


    public Tab userSalesTab;


    public void initialize() {
                try {

                        Parent studentTab= FXMLLoader.load(getClass().getResource("/view/salesTab.fxml"));
                        userSalesTab.setContent(studentTab);
                }catch (Exception e){
                    System.out.println("student tab not loaded  ");
                        }

    }
}
