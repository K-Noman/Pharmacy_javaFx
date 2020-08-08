package controller;

import com.jfoenix.controls.JFXButton;
import controller.table.salesTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class salesController {



    @FXML
    private JFXButton searchSales;
    @FXML
    private TableView salesTableView;
    @FXML
    private TableColumn<salesTable,String> productIDColumn;
    @FXML
    private TableColumn<salesTable,String> productNameColumn;
    @FXML
    private TableColumn<salesTable,String> productDoseColumn;
    @FXML
    private TableColumn<salesTable,String> priceColumn;
    @FXML
    private TableColumn<salesTable,String> quantityColumn;
    @FXML
    private TableColumn<salesTable,String> AmountColumn;



    public void initialize(){
        renderSalesTable();


    }
    public void searchSalesAction(ActionEvent event) {







    }
   private void renderSalesTable(){
       List<salesTable> sales=salesTable.getAll();
       System.out.println(salesTable.getAll());
       System.out.println(sales+" bjh");

       this.productIDColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
       this.productNameColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_NAME"));
       this.productDoseColumn.setCellValueFactory(new PropertyValueFactory<>("DOSE"));
       this.quantityColumn.setCellValueFactory(new PropertyValueFactory<>("QUANTITY"));
       this.priceColumn.setCellValueFactory(new PropertyValueFactory<>("PRICE"));
       this.AmountColumn.setCellValueFactory(new PropertyValueFactory<>("AMMONT"));
       salesTableView.getItems().addAll(sales);




   }


}
