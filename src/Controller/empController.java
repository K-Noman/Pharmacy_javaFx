package controller;

import com.jfoenix.controls.JFXTextField;
import controller.addNew.addEmployee;
import controller.table.employeeTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class empController {



    public JFXTextField empID;
    public JFXTextField empName;
    public JFXTextField empLastName;
    @FXML
    private TableView employeeView;
    @FXML
    private TableColumn<employeeTable, String> empIDColumn;
    @FXML
    private TableColumn<employeeTable, String> empNameColumn;
    @FXML
    private TableColumn<employeeTable, String> empLastNameColumn;
    @FXML
    private TableColumn<employeeTable, String> empMobileColumn;
    @FXML
    private TableColumn<employeeTable, String> empEmailColumn;
    @FXML
    private TableColumn<employeeTable, String> empPasswordColumn;



    addEmployee employee=new addEmployee();

    public void initialize() {
       renderTable();

    }

    public void saveEmployee(ActionEvent event) {
        System.out.println("Button clicked");


    }


    private void renderTable(){
        List<employeeTable> employee = employeeTable.getAll();
        this.empIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.empNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.empLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.empMobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        this.empEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.empPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        employeeView.getItems().addAll(employee);
        System.out.println(employeeView);
        System.out.println(employee);


    }



}
