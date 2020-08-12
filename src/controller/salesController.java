package controller;

import Classes.dbDataBase;
import Classes.sales;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class salesController {


    @FXML
    private JFXTextField searchSale;
    @FXML
    private TableView userSalesTable;
    @FXML
    private TableColumn<sales,String> productIDColumn;
    @FXML
    private TableColumn<sales,String> productNameColumn;
    @FXML
    private TableColumn<sales,String> productQuantityColumn;
    @FXML
    private TableColumn<sales,String> productPriceColumn;
    @FXML
    private TableColumn<sales,String> productBillColumn;




    public void initialize(){
        renderSalesTable();


    }
    public void searchSalesAction(KeyEvent event) {
        ObservableList<sales> dataList;
        System.out.println(dbDataBase.getDataSales());
        this.productIDColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
        this.productNameColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_NAME"));
        this.productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("QUANTITY"));
        this.productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("PRICE"));
        this.productBillColumn.setCellValueFactory(new PropertyValueFactory<>("AMMONT"));
        dataList = dbDataBase.getDataSales();
        userSalesTable.setItems(dataList);
        FilteredList<sales> filteredData = new FilteredList<>(dataList, asv -> true);

        searchSale.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(product -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (product.getPRODUCT_NAME().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
//                else if (product.getPRODUCT_Name().toLowerCase().indexOf(lowerCaseFilter)!= -1)
//                    return true;
                else
                    return false;
            });
        });
        SortedList<sales> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(userSalesTable.comparatorProperty());
        userSalesTable.setItems(sortedData);
    }

    public void renderSalesTable(){
        ObservableList<sales> dataList ;
        this.productIDColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
        this.productNameColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_NAME"));
        this.productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("QUANTITY"));
        this.productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("PRICE"));
        this.productBillColumn.setCellValueFactory(new PropertyValueFactory<>("AMMONT"));
        dataList=dbDataBase.getDataSales();
        userSalesTable.getItems().addAll(dataList);
    }



}
