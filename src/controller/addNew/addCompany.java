package controller.addNew;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.table.companyTable;
import controller.table.employeeTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class addCompany {


    @FXML
    private JFXTextField CompanyID;
    @FXML
    private JFXTextField CompanyName;
    @FXML
    private JFXTextField CompanyAddress;
    @FXML
    private JFXTextField CompanyPhone;
    @FXML
    private JFXButton addCompany;
    @FXML
    private TableView companyTableView;
    @FXML
    private TableColumn<companyTable,String> companyIDColumn;
    @FXML
    private TableColumn<companyTable,String> companyNameColumn;
    @FXML
    private TableColumn<companyTable,String> companyAddressColumn;
    @FXML
    private TableColumn<companyTable,String> companyPhoneColumn;



    public void initialize(){

        renderCompanyTable();

    }

    public void addCompanyAction(ActionEvent event) {
        companyTable companyTable=new companyTable(CompanyID.getText(),CompanyName.getText(),CompanyAddress.getText(),CompanyPhone.getText());
        companyTable.addCompany();
        companyTableView.getItems().clear();
        renderCompanyTable();


    }



    private void renderCompanyTable(){
            List<companyTable> company = companyTable.getAll();
            this.companyIDColumn.setCellValueFactory(new PropertyValueFactory<>("COMPANY_ID"));
            this.companyNameColumn.setCellValueFactory(new PropertyValueFactory<>("COMPANYNAME"));
            this.companyAddressColumn.setCellValueFactory(new PropertyValueFactory<>("COMPANYADDRESS"));
            this.companyPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("COMPANYPHONE"));
            companyTableView.getItems().addAll(company);
        System.out.println(companyTable.getAll());


        }



}
