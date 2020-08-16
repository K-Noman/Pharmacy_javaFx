package controller.addNew;

import Classes.TEMP;
import Classes.dbDataBase;
import Classes.stock;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.table.salesTable;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.util.List;

public class salesTabController {

    @FXML
    private JFXTextField bill;

    @FXML
    private VBox namesListVBox;
    @FXML
    private VBox quantityListVBox;
    @FXML
    private VBox priceListVBox;
    @FXML
    private Button btnFinalise;
    @FXML
    private JFXTextField productChoice;

    @FXML
    private JFXTextField productName;
    @FXML
    private JFXTextField inStock;
    @FXML
    private JFXTextField quantity;
    @FXML
    private JFXButton confirmPurchase;
    @FXML
    private JFXButton print;
    @FXML
    private TableView userSalesTable;
    @FXML
    private TableColumn<salesTable, String> productIDColumn;
    @FXML
    private TableColumn<salesTable, String> productNameColumn;
    @FXML
    private TableColumn<salesTable, String> productQuantityColumn;
    @FXML
    private TableColumn<salesTable, String> productPriceColumn;
    @FXML
    private TableColumn<salesTable, String> productBillColumn;
    @FXML
    private TableView stockTableView;
    @FXML
    private TableColumn<stock, String> stockIDColumn;
    @FXML
    private TableColumn<stock, String> stockNameColumn;
    @FXML
    private TableColumn<stock, String> stockSellingPriceColumn;
    @FXML
    private TableColumn<stock, String> stockCompanyIDColumn;
    @FXML
    private TableColumn<stock, String> stockStockColumn;


    public void initialize() {
        renderSalesTable();
        renderStockTable();
        TextFields.bindAutoCompletion(productName,dbDataBase.getStockNameColumn());
//        dbDataBase.clearTEMP();
    }


    public void renderSalesTable() {
        List<salesTable> sales = salesTable.getAll();
        this.productIDColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
        this.productNameColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_NAME"));
        this.productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("QUANTITY"));
        this.productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("PRICE"));
        this.productBillColumn.setCellValueFactory(new PropertyValueFactory<>("AMMONT"));
        userSalesTable.getItems().addAll(sales);
    }
    private void renderStockTable() {
        ObservableList<stock> dataList;
        this.stockIDColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
        this.stockNameColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_Name"));
        this.stockSellingPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Selling_Price"));
        this.stockCompanyIDColumn.setCellValueFactory(new PropertyValueFactory<>("Company_ID"));
        this.stockStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        dataList = dbDataBase.getDataStock();
        stockTableView.setItems(dataList);

    }


    public void searchStockAction(KeyEvent event) {
        // key Pressed
        SearchStock();
        if (productName.getText().isEmpty()) inStock.setText(null);




    }
    public  void SearchStock() {
        ObservableList<stock> dataList;
        this.stockIDColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
        this.stockNameColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_Name"));
        this.stockSellingPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Selling_Price"));
        this.stockCompanyIDColumn.setCellValueFactory(new PropertyValueFactory<>("Company_ID"));
        this.stockStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        dataList = dbDataBase.getDataStock();
        stockTableView.setItems(dataList);
        FilteredList<stock> filteredList = new FilteredList<>(dataList, search -> true);

        productName.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(product -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (product.getPRODUCT_Name().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }

                else
                    return false;

            });
        });
        SortedList<stock> stockSortedList = new SortedList<>(filteredList);
        stockSortedList.comparatorProperty().bind(stockTableView.comparatorProperty());
        stockTableView.setItems(stockSortedList);
    }

    public void fillStock(KeyEvent event) {
//        onKeyReleased
        if (productName.getText().isEmpty()) inStock.setText(null);
        else{
            try {
            inStock.setText(valueOfStock());
        }catch (Exception e){

        }
        }

    }
    public String valueOfStock(){
         String value=dbDataBase.findStock(productName.getText());
         return value;



    }



    @FXML
    private void addProducts() {



        try {
            if (Integer.parseInt(quantity.getText()) <= 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Cannot have less than 0 quantity", ButtonType.CLOSE);
                alert.setHeaderText("Error");
                alert.setTitle("Error");
                alert.show();
                return;
               }
            double total=Double.parseDouble(quantity.getText()) * Double.parseDouble(dbDataBase.findSellingPrice(dbDataBase.findSearchID(productName.getText())));
            dbDataBase.insertIntoTemp(productName.getText(),quantity.getText(),total);

            String Name=productName.getText().trim();
            String Id=dbDataBase.findSearchID(Name);
            String Quantity=quantity.getText().trim();
            String SellingPrice=dbDataBase.findSellingPrice(Id);
            String Bill=dbDataBase.getTEMPTotalColumn();


            dbDataBase.insertIntoSales(Id,Name,Quantity,SellingPrice,Bill);
            updateBasket();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please put the correct data types in the fields"
                    , ButtonType.CLOSE);
            alert.setHeaderText("Error");
            alert.setTitle("Error");
            alert.show();
        }









    }
    private void updateBasket() {
        namesListVBox.getChildren().clear();
        quantityListVBox.getChildren().clear();
        priceListVBox.getChildren().clear();
        bill.setText(null);
        clearFields();

        for (TEMP ignored : dbDataBase.getDataTEMP()) {
            Label name = new Label(" "+ignored.getNAME());
            Label quantity = new Label("" + ignored.getQUANTITY());
            Label amount=new Label(""+ignored.getTOTAL());


            name.setTooltip(new Tooltip((ignored.getNAME())));
            quantity.setTooltip(new Tooltip("" + ignored.getQUANTITY()));
            amount.setTooltip(new Tooltip(""+ignored.getTOTAL()));

            namesListVBox.getChildren().add(name);
            quantityListVBox.getChildren().add(quantity);
            priceListVBox.getChildren().add(amount);
        }
        bill.setText(dbDataBase.getTEMPTotalColumn());
    }




    private  void clearFields(){
        productName.setText(null);
        inStock.setText(null);
        quantity.setText(null);

    }

    public void generateReceipt(ActionEvent event) {

        try {
            Stage stage=new Stage();
            Parent  root = FXMLLoader.load(getClass().getResource("/view/bill.fxml"));
            stage.setTitle("Bill ");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            dbDataBase.removeItem();
        }catch (Exception e){
            e.printStackTrace();
        }
        updateBasket();

    }



}