//package test;
//
//import Classes.dbDataBase;
//import Classes.sales;
//import com.jfoenix.controls.JFXTextField;
//import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Alert;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import org.controlsfx.control.Notifications;
//
//import java.util.List;
//
//public class testController {
//
//
//    public JFXTextField filterField;
//    @FXML
//    private TableView userSalesTable;
//    @FXML
//    private TableColumn<controller.table.salesTable,String> productIDColumn;
//    @FXML
//    private TableColumn<controller.table.salesTable,String> productNameColumn;
//    @FXML
//    private TableColumn<controller.table.salesTable,String> productQuantityColumn;
//    @FXML
//    private TableColumn<controller.table.salesTable,String> productPriceColumn;
//    @FXML
//    private TableColumn<controller.table.salesTable,String> productBillColumn;
//
//    public void initialize(){
//        renderSalesTable();
//
//    }
//
//
//    public void SearchTextAction() {
//        System.out.println(dbDataBase.getDataSales() + "kjb k");
//        ObservableList<sales> dataList;
//        System.out.println(dbDataBase.getDataSales());
//        this.productIDColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
//        this.productNameColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_NAME"));
//        this.productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("QUANTITY"));
//        this.productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("PRICE"));
//        this.productBillColumn.setCellValueFactory(new PropertyValueFactory<>("AMMONT"));
//        dataList = dbDataBase.getDataSales();
//        userSalesTable.setItems(dataList);
//        FilteredList<sales> filteredData = new FilteredList<>(dataList, b -> true);
//
//        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate(person -> {
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (person.getPRODUCT_NAME().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true; // Filter matches username
//                } else if (person.getPRODUCT_NAME().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true; // Filter matches password
//                } else if (person.getPRICE().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true; // Filter matches password
//                } else if (String.valueOf(person.getAMMONT()).indexOf(lowerCaseFilter) != -1)
//                    return true;// Filter matches email
//
//                else
//                    return false; // Does not match.
//            });
//        });
//        SortedList<sales> sortedData = new SortedList<>(filteredData);
//        sortedData.comparatorProperty().bind(userSalesTable.comparatorProperty());
//        userSalesTable.setItems(sortedData);
//    }
//
//    public void renderSalesTable(){
//        List<testTable> sales= testTable.getAll();
//        this.productIDColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_ID"));
//        this.productNameColumn.setCellValueFactory(new PropertyValueFactory<>("PRODUCT_NAME"));
//        this.productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("QUANTITY"));
//        this.productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("PRICE"));
//        this.productBillColumn.setCellValueFactory(new PropertyValueFactory<>("AMMONT"));
//        userSalesTable.getItems().addAll(sales);
//    }
//
//
//    public void SearchBUttonAction(ActionEvent event) {
//
//        Notifications.create()
//                .title("Title Text")
//                .text("Hello World 0!")
//                .showWarning();
//
//
//
//
//
//    }
//}
