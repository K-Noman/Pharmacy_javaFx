package controller.addNew;

import Classes.company;
import Classes.dbDataBase;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import controller.table.companyTable;
import controller.table.employeeTable;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import org.controlsfx.control.Notifications;

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
        if (validateCompanyInput()){
            companyTable companyTable=new companyTable(CompanyID.getText(),CompanyName.getText(),CompanyAddress.getText(),CompanyPhone.getText());
            companyTable.addCompany();
            companyTableView.getItems().clear();
            renderCompanyTable();
        }


    }
    public void searchCompany(KeyEvent event) {
        searchCompanyDate();

    }

    private void searchCompanyDate() {
        ObservableList dataList;
        this.companyIDColumn.setCellValueFactory(new PropertyValueFactory<>("COMPANY_ID"));
        this.companyNameColumn.setCellValueFactory(new PropertyValueFactory<>("COMPANYNAME"));
        this.companyAddressColumn.setCellValueFactory(new PropertyValueFactory<>("COMPANYADDRESS"));
        this.companyPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("COMPANYPHONE"));
        dataList= dbDataBase.getDataCompany();
        companyTableView.setItems(dataList);
        FilteredList<company> filteredList=new FilteredList<>(dataList, cev->true);

        CompanyID.textProperty().addListener((observable,oldValue,newValue)->{
            filteredList.setPredicate(product ->{
                if (newValue==null||newValue.trim()==null){
                    return true;
                }
                String lowerCaseFilter=newValue.toLowerCase();
                if (product.getCOMPANY_ID().indexOf(lowerCaseFilter)!=1){
                    return true;
                }else if (product.getCOMPANYNAME().indexOf(lowerCaseFilter)!=1){
                    return true;
                }
                else return false;

            });
            SortedList<company> sortedList =new SortedList<>(filteredList);
               sortedList.comparatorProperty().bind(companyTableView.comparatorProperty());
               companyTableView.setItems(sortedList);



        });



    }


    private void renderCompanyTable(){
            List<companyTable> company = companyTable.getAll();
            this.companyIDColumn.setCellValueFactory(new PropertyValueFactory<>("COMPANY_ID"));
            this.companyNameColumn.setCellValueFactory(new PropertyValueFactory<>("COMPANYNAME"));
            this.companyAddressColumn.setCellValueFactory(new PropertyValueFactory<>("COMPANYADDRESS"));
            this.companyPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("COMPANYPHONE"));
            companyTableView.getItems().addAll(company);

    }

        private boolean validateCompanyInput(){
         if (CompanyID.getText().isEmpty()){
             alert("Enter CompanyID");
             return false;
         } else if (CompanyName.getText().isEmpty()) {
             alert("Enter CompanyName");
             return false;
         }else if (CompanyAddress.getText().isEmpty()) {
             alert("Enter CompanyAddress");
             return false;
         }else if (CompanyName.getText().isEmpty()) {
             alert("Enter CompanyPhone");
             return false;
         }
         return true;



        }

    public void alert(String title) {
        Notifications.create()
                .title("Employee")
                .text(title)
                .showWarning();
    }



}
