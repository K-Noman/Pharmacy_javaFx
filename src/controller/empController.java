package controller;

import Classes.dbDataBase;
import Classes.employee;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.textfield.TextFields;


public class empController {
    @FXML
    private JFXTextField empName;
    @FXML
    private TableView employeeView;
    @FXML
    private TableColumn<employee, String> empIDColumn;
    @FXML
    private TableColumn<employee, String> empNameColumn;
    @FXML
    private TableColumn<employee, String> empLastNameColumn;
    @FXML
    private TableColumn<employee, String> empMobileColumn;
    @FXML
    private TableColumn<employee, String> empEmailColumn;
    @FXML
    private TableColumn<employee, String> empPasswordColumn;


    public void initialize() {
        renderTable();
        TextFields.bindAutoCompletion(empName,dbDataBase.getEmployeeNameColumn());

    }

    public void saveEmployee(ActionEvent event) {
        System.out.println("Button clicked");


    }


    private void renderTable() {
        ObservableList<employee> dataList;
        this.empIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.empNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.empLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.empMobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        this.empEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.empPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        dataList = dbDataBase.getDataEmployee();
        employeeView.setItems(dataList);
        System.out.println("Rendering Employee Table");

    }


    public void searchEmployee(javafx.scene.input.KeyEvent event ) {
        ObservableList<employee> dataList;
        this.empIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.empNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.empLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.empMobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        this.empEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.empPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        dataList = dbDataBase.getDataEmployee();
        employeeView.setItems(dataList);
        FilteredList<employee> filteredList = new FilteredList<>(dataList, search -> true);

        empName.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(product -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (product.getId().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }else if (product.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }

                else
                    return false;

            });
        });
        SortedList<employee> employeeSortedList = new SortedList<>(filteredList);
        employeeSortedList.comparatorProperty().bind(employeeView.comparatorProperty());
        employeeView.setItems(employeeSortedList);

    }


}


