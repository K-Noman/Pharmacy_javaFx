package test;


import Classes.dbDataBase;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ResourceBundle;

public class testController implements Initializable {


    public JFXTextField SearchID;
    public TableView salesTableView;
    public TableColumn<sales,String> productIDColumn;
    public TableColumn<sales,String> productNameColumn;
    public TableColumn<sales,String> productQuantityColumn;
    public TableColumn<sales,String> productPriceColumn;
    public TableColumn<sales,String> productBillColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        renderTable();

        System.out.println("initialized");
        System.out.println(dbDataBase.getSalesNameColumn());
        TextFields.bindAutoCompletion(SearchID,dbDataBase.getSalesNameColumn());



    }



    public void SearchTextAction(KeyEvent event) {

    }

    private void renderTable(){
        ObservableList<Classes.sales> dataList;
        this.productIDColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
        this.productNameColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_NAME"));
        this.productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("QUANTITY"));
        this.productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("PRICE"));
        this.productBillColumn.setCellValueFactory(new PropertyValueFactory<>("AMMONT"));
        dataList = dbDataBase.getDataSales();
        salesTableView.setItems(dataList);
    }
}
