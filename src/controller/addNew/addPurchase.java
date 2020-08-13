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
import org.controlsfx.control.Notifications;

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
        if (validatePurchaseInput()){
            purchaseTable purchaseTable=new purchaseTable(productID.getText(),productName.getText(),productCostPrice.getText(),productSellingPrice.getText(),productExpiryDate.getValue().toString(),productProductionDate.getValue().toString(),productPlace.getText(),productCompany.getText(),productPack.getText(),productQuantity.getText());
            purchaseTable.addPurchase();
            clearView();
            productTableView.getItems().clear();
            renderTable();
        }

    }
    private void renderTable(){
       List<purchaseTable> purchase=purchaseTable.getAll();
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
//       productTableView.getItems().addAll(purchase);
       productTableView.getItems().addAll(purchase);

    }


    public void clearView(){
        productID.clear();
        productName.clear();
        productCostPrice.clear();
        productSellingPrice.clear();
        productExpiryDate.setValue(null);
        productProductionDate.setValue(null);
        productPlace.clear();
        productCompany.clear();
        productPack.clear();
        productQuantity.clear();
    }

    public void alert(String title) {
        Notifications.create()
                .title("Employee")
                .text(title)
                .showWarning();
    }


    private boolean validatePurchaseInput(){
        if (productID.getText().isEmpty()) {
            alert("Enter productID");
            return false;
        }
        else if (productName.getText().isEmpty()) {
            alert("Enter productName");
            return false;
        }
        else if (productCostPrice.getText().isEmpty()) {
            alert("Enter productCostPrice");
            return false;
        }
        else if (productSellingPrice.getText().isEmpty()){
            alert("Enter productSellingPrice");
            return false;
        }
        else if (productExpiryDate.getValue().toString().isEmpty()) {
            alert("Enter productExpiryDate");
            return false;
        }
        else if (productProductionDate.getValue().toString().isEmpty()) {
            alert("Enter productProductionDate");
            return false;
        }
        else if (productPlace.getText().isEmpty()){
            alert("Enter productPlace");
            return false;
        }
        else if (productCompany.getText().isEmpty()) {
            alert("Enter productCompany");
            return false;
        }
        else if (productPack.getText().isEmpty()) {
            alert("Enter productPack");
            return false;
        }
        else if (productQuantity.getText().isEmpty()) {
            alert("Enter productQuantity");
            return false;
        }

        return true;
    }






}
