package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

public class userController {


    public Tab userSalesTab;
    public Tab userPurchaseTab;


    public void initialize() {
        showSalesTab();
        showPurchaseTab();


    }

    private void showSalesTab(){
        try {
            Parent salesTab= FXMLLoader.load(getClass().getResource("/view/user/userSalesTab.fxml"));
            userSalesTab.setContent(salesTab);
        }catch (Exception e){
            System.out.println("user Sales tab not loaded  ");
        }
    }
    private void showPurchaseTab(){
        try {
            Parent purchaseTab= FXMLLoader.load(getClass().getResource("/view/addNew/purchaseAdd.fxml"));
            userPurchaseTab.setContent(purchaseTab);
        }catch (Exception e){
            System.out.println("user Purchase  tab not loaded  ");
        }
    }
}
