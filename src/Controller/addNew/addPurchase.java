package controller.addNew;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.table.purchaseTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class addPurchase {


    @FXML private JFXTextField productID;
    @FXML private JFXTextField productName;
    @FXML private JFXTextField productCostPrice;
    @FXML private JFXTextField productSellingPrice;
    @FXML private DatePicker productExpiryDate;
    @FXML private DatePicker productProductionDate;
    @FXML private JFXTextField productPlace;
    @FXML private JFXTextField productCompany;
    @FXML private JFXTextField productPack;
    @FXML private JFXTextField productQuantity;
    @FXML private JFXButton addPurchase;
    @FXML private TableView productTableView;
    @FXML private TableColumn<purchaseTable,String> productIDColumn;
    @FXML private TableColumn<purchaseTable,String> productNameColumn;
    @FXML private TableColumn<purchaseTable,String> productCostPriceColumn;
    @FXML private TableColumn<purchaseTable,String> productSellingPriceColumn;
    @FXML private TableColumn<purchaseTable,String> productExpiryDateColumn;
    @FXML private TableColumn<purchaseTable,String> productProductionDateColumn;
    @FXML private TableColumn<purchaseTable,String> productPlaceColumn;
    @FXML private TableColumn<purchaseTable,String> productCompanyColumn;
    @FXML private TableColumn<purchaseTable,String> productPackColumn;
    @FXML private TableColumn<purchaseTable,String> productQin_One_packColumn;
    @FXML private TableColumn<purchaseTable,String> productStockColumn;



    public void initialize(){
        System.out.println("table render ?");
        renderTable();

    }

    public void savePurchase(ActionEvent event) {
        purchaseTable purchaseTable=new purchaseTable(productID.getText(),productName.getText(),productCostPrice.getText(),productSellingPrice.getText(),productExpiryDate.getValue().toString(),productProductionDate.getValue().toString(),productPlace.getText(),productCompany.getText(),productPack.getText(),productQuantity.getText());
        purchaseTable.addPurchase();
        productTableView.getItems().clear();
        renderTable();


    }
    private void renderTable(){
       List<purchaseTable> purchase=purchaseTable.getAll();
        System.out.println(purchase+" giu");
        System.out.println(purchaseTable.getAll());
        System.out.println(productTableView);
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
//       productTableView.getItems().addAll(purchase);
       productTableView.getItems().addAll(purchase);

    }






}
