package classes;
import controller.addNew.addEmployee;
import controller.table.purchaseTable;

import java.sql.SQLException;


public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        purchaseTable purchase =new purchaseTable("1231","Aspirin","120mg","5","10","21-feb-99","20-feb-99","r-up","VEA","10","10");
        purchaseTable purchaseTable=new purchaseTable();
//        purchase.addPurchase();
        System.out.println(purchaseTable.getAll());
        addEmployee addEmployee=new addEmployee();
        addEmployee.renderTable();



    }




}
