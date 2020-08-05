package test;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sun.plugin2.message.ShowStatusMessage;

import javax.management.Notification;
import java.util.List;

public class testController {



    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField testID;
    @FXML
    private TableColumn<testTable,String> nameColumn;
    @FXML
    private TableColumn<testTable,String> idColumn;
    @FXML
    private TableColumn<testTable,String> phoneColumn;
    @FXML
    private TableView employeeView;
    public void initialize(){
        renderTable();
    }


    public void renderTable(){
        List<testTable> employee= testTable.getAll();
        this.nameColumn.setCellValueFactory(new PropertyValueFactory<>("CNAME"));
        this.idColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        employeeView.getItems().addAll(employee);


    }


    public  void saveTestButton(ActionEvent event) {
        System.out.println(name.getText());
        System.out.println(testID.getText());
        testTable testtable =new testTable(name.getText(),testID.getText(),phone.getText());
        testtable.save();
        System.out.println(testtable.getAll());
        System.out.println(testtable.getAll().size());









    }
}
