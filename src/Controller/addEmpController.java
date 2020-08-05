package controller;

import com.jfoenix.controls.JFXTextField;
import controller.addNew.addEmployee;
import controller.table.employeeTable;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class addEmpController {


    public JFXTextField empID;
    public JFXTextField empName;
    public JFXTextField empLastName;
    public JFXTextField empMobile;
    public JFXTextField empPassword;
    public TableView employeeView;
    public TableColumn<employeeTable,String> empIDColumn;
    public TableColumn<employeeTable,String> empNameColumn;
    public TableColumn<employeeTable,String> empLastNameColumn;
    public TableColumn<employeeTable,String> empMobileColumn;
    public TableColumn<employeeTable,String> empEmailColumn;
    public TableColumn<employeeTable,String> empPasswordColumn;
    public JFXTextField empEmail;

    public void initialize(){
        renderTable();
    }

    public void saveEmployee(ActionEvent event) throws SQLException, ClassNotFoundException {
        String EMPID =this.empID.getText();
        String firstname=this.empName.getText();
        String LASTNAME = this.empLastName .getText();
        String MOBILE = this.empMobile .getText();
        String  EMAIL= this.empEmail .getText();
        String PASSWORD = this.empPassword .getText();

        System.out.println(EMPID);
        System.out.println(firstname);
        System.out.println(LASTNAME);
        System.out.println(MOBILE);
        System.out.println(EMAIL);
        System.out.println(PASSWORD);
        employeeTable employeeTable=new employeeTable(EMPID,firstname,LASTNAME,MOBILE,EMAIL,PASSWORD);
        employeeTable.saveEmployee();
        employeeView.getItems().clear();
        clearView();
        renderTable();
        System.out.println(employeeTable.getAll());


    }

    private void renderTable(){
        List<employeeTable> employee=employeeTable.getAll();
        this.empIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.empNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        this.empLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        this.empMobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        this.empEmailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        this.empPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        employeeView.getItems().addAll(employee);
    }

    private void clearView(){
        empID.clear();
        empName.clear();
        empLastName.clear();
        empMobile.clear();
        empEmail.clear();
        empPassword.clear();



    }



}
