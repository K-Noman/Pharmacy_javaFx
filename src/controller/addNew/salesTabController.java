package controller.addNew;

import Classes.dbDataBase;
import Classes.stock;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.table.salesTable;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import org.controlsfx.control.textfield.TextFields;

import java.util.List;

public class salesTabController {


    public JFXTextField productName;
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

//        List<stockTable> stock=stockTable.getAll();
//        this.stockIDColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
//        this.stockNameColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_Name"));
//        this.stockSellingPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Selling_Price"));
//        this.stockCompanyIDColumn.setCellValueFactory(new PropertyValueFactory<>("Company_ID"));
//        this.stockStockColumn.setCellValueFactory(new PropertyValueFactory<>("Classes.stock"));
//        stockTableView.getItems().addAll(stock);
    }


    public void searchStockAction(KeyEvent event) {
        SearchStock();

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


}