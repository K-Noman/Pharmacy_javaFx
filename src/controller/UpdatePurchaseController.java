package controller;

import Classes.dbDataBase;
import Classes.purchase;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import org.controlsfx.control.textfield.TextFields;

import java.util.List;

public class UpdatePurchaseController {
    @FXML
    private JFXTextField productName;
    @FXML
    private JFXTextField productQuantity;
    @FXML
    private JFXButton updatePurchase;

    @FXML
    private TableView productTableView;
    @FXML private TableColumn<purchase,String> productIDColumn;
    @FXML private TableColumn<purchase,String> productNameColumn;
    @FXML private TableColumn<purchase,String> productCostPriceColumn;
    @FXML private TableColumn<purchase,String> productSellingPriceColumn;
    @FXML private TableColumn<purchase,String> productExpiryDateColumn;
    @FXML private TableColumn<purchase,String> productProductionDateColumn;
    @FXML private TableColumn<purchase,String> productPlaceColumn;
    @FXML private TableColumn<purchase,String> productCompanyColumn;
    @FXML private TableColumn<purchase,String> productPackColumn;
    @FXML private TableColumn<purchase,String> productQin_One_packColumn;
    @FXML private TableColumn<purchase,String> productStockColumn;
    ObservableList<purchase> dataList;

    public void initialize(){
        System.out.println("table render update purchase ");
        TextFields.bindAutoCompletion(productName,dbDataBase.getPurchaseNameColumn());
        renderTable();

    }


    public void updatePurchase(ActionEvent event) {
       if (productName.getText().trim().isEmpty() ||productQuantity.getText().trim().isEmpty()){
           Alert alert = new Alert(Alert.AlertType.ERROR, " Text Field Must Non Empty "
                   , ButtonType.CLOSE);
           alert.setHeaderText("Error");
           alert.setTitle("Error");
           alert.show();
           return;
       }
        String id=dbDataBase.findSearchID(productName.getText());
        dbDataBase.updatePurchase(id,productQuantity.getText());
        productTableView.getItems().clear();
        renderTable();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Data Uprated"
                , ButtonType.CLOSE);
        alert.setHeaderText("Updated");
        alert.setTitle("Updated");
        alert.show();




    }


    private void renderTable(){

        System.out.println("Purchase table rendering ");
        this.productIDColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
        this.productNameColumn.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        this.productCostPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productCostPrice"));
        this.productSellingPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productSellingPrice"));
        this.productExpiryDateColumn.setCellValueFactory(new PropertyValueFactory<>("productExpiryDate"));
        this.productProductionDateColumn.setCellValueFactory(new PropertyValueFactory<>("productProductionDate"));
        this.productPlaceColumn.setCellValueFactory(new PropertyValueFactory<>("productPlace"));
        this.productCompanyColumn.setCellValueFactory(new PropertyValueFactory<>("productCompany"));
        this.productPackColumn.setCellValueFactory(new PropertyValueFactory<>("productPack"));
        this.productQin_One_packColumn.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
        this.productStockColumn.setCellValueFactory(new PropertyValueFactory<>("productInStock"));
        dataList=dbDataBase.getDataPurchase();
        productTableView.getItems().addAll(dataList);

    }

    public void searchPurchase(KeyEvent event) {




        //        dataList=dbDataBase.getDataPurchase();
//        this.productIDColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
//        this.productNameColumn.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
//        this.productCostPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productCostPrice"));
//        this.productSellingPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productSellingPrice"));
//        this.productExpiryDateColumn.setCellValueFactory(new PropertyValueFactory<>("productExpiryDate"));
//        this.productProductionDateColumn.setCellValueFactory(new PropertyValueFactory<>("productProductionDate"));
//        this.productPlaceColumn.setCellValueFactory(new PropertyValueFactory<>("productPlace"));
//        this.productCompanyColumn.setCellValueFactory(new PropertyValueFactory<>("productCompany"));
//        this.productPackColumn.setCellValueFactory(new PropertyValueFactory<>("productPack"));
//        this.productQin_One_packColumn.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
//        this.productStockColumn.setCellValueFactory(new PropertyValueFactory<>("productInStock"));
//        dataList = dbDataBase.getDataPurchase();
////        productTableView.setItems(dataList);
//        FilteredList<purchase> filteredList = new FilteredList<>(dataList, search -> true);
//
//        productName.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredList.setPredicate(product -> {
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//                String lowerCaseFilter = newValue.toLowerCase();
//                if (product.getProductName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true;}
//                    else
//                    return false;
//
//            });
//        });
//        SortedList<purchase> employeeSortedList = new SortedList<>(filteredList);
//        employeeSortedList.comparatorProperty().bind(productTableView.comparatorProperty());
//        productTableView.setItems(employeeSortedList);
////
//
//
//
    }




}
