package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

public class userController {


    public Tab userSalesTab;


    public void initialize() {
                try {

                        Parent salesTab= FXMLLoader.load(getClass().getResource("/view/user/userSalesTab.fxml"));
                        userSalesTab.setContent(salesTab);
                }catch (Exception e){
                    System.out.println("student tab not loaded  ");
                        }

    }
}
