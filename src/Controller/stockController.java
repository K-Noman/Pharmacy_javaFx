package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.table.salesTable;
import controller.table.stockTable;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    }

    public void searchStockAction(ActionEvent event) {
        System.out.println(stockTable.getAll());

    }


    public void renderStockTable(){
        List<stockTable> sales=stockTable.getAll();
        this.stockIDColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
        this.stockNameColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_Name"));
        this.stockSellingPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Selling_Price"));
        this.stockCompanyIDColumn.setCellValueFactory(new PropertyValueFactory<>("Company_ID"));
        this.stockStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        stockTableView.getItems().addAll(sales);





    }
}
