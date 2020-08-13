package controller;

import Classes.dbDataBase;
import Classes.stock;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.table.salesTable;
import controller.table.stockTable;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.textfield.TextFields;

import java.util.List;

public class stockController {


    public JFXButton productStock;
    public TableView stockTableView;
    public TableColumn<salesTable,String> stockIDColumn;
    public TableColumn<salesTable,String> stockNameColumn;
    public TableColumn<salesTable,String> stockSellingPriceColumn;
    public TableColumn<salesTable,String> stockCompanyIDColumn;
    public TableColumn<salesTable,String> stockStockColumn;
    public JFXTextField productID;
    public JFXTextField productName;


    public void initialize(){
        renderStockTable();
        TextFields.bindAutoCompletion(productName,dbDataBase.getStockNameColumn());
    }

    public void searchStockAction(javafx.scene.input.KeyEvent event) {
        SearchStock();
    }



    public  void renderStockTable(){
        List<stockTable> stock=stockTable.getAll();
        this.stockIDColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
        this.stockNameColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_Name"));
        this.stockSellingPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Selling_Price"));
        this.stockCompanyIDColumn.setCellValueFactory(new PropertyValueFactory<>("Company_ID"));
        this.stockStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        stockTableView.getItems().addAll(stock);
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
//                else if (product.getPRODUCT_Name().toLowerCase().indexOf(lowerCaseFilter)!= -1)
//                    return true;
                else
                    return false;

            });
        });
        SortedList<stock> stockSortedList = new SortedList<>(filteredList);
        stockSortedList.comparatorProperty().bind(stockTableView.comparatorProperty());
        stockTableView.setItems(stockSortedList);
    }



}
