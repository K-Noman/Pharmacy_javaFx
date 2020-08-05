package controller;

import com.jfoenix.controls.JFXTextField;
import controller.table.employeeTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class empController {


    public TableView employeeView;
    public TableColumn empIDColumn;
    public TableColumn empNameColumn;
    public JFXTextField empID;
    public JFXTextField empName;
    public JFXTextField empLastName;


    public void saveEmployee(ActionEvent event) {
        System.out.println("Button clicked");


    }
}
