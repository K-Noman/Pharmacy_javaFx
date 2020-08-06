package controller.addNew;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class addPurchase {

    @FXML private JFXTextField productID;
    @FXML private JFXTextField productName;
    @FXML private JFXTextField productDose;
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
    @FXML private TableColumn productIDColumn;
    @FXML private TableColumn productNameColumn;
    @FXML private TableColumn productDoseColumn;
    @FXML private TableColumn productCostPriceColumn;
    @FXML private TableColumn productSellingPriceColumn;
    @FXML private TableColumn productExpiryDateColumn;
    @FXML private TableColumn productProductionDateColumn;
    @FXML private TableColumn productPlaceColumn;
    @FXML private TableColumn productCompanyColumn;
    @FXML private TableColumn productStockColumn;

    public void savePurchase(ActionEvent event) {

    }






}
