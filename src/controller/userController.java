package controller;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

public class userController {


    public Tab userSalesTab;
    public Tab userPurchaseTab;
    public Tab editPurchaseTab;


    public void initialize() {
        showSalesTab();
        showPurchaseTab();
        showEditPurchaseTab();


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

    private void showEditPurchaseTab(){
        try {
            Parent purchaseTab= FXMLLoader.load(getClass().getResource("/view/updatePurchase.fxml"));
            editPurchaseTab.setContent(purchaseTab);
        }catch (Exception e){
            System.out.println("Edit Purchase  tab not loaded  ");
        }

    }

    public void refreshAdd(Event event) {
        showEditPurchaseTab();

    }

    public void refreshAddNew(Event event) {
        showPurchaseTab();

    }
}
