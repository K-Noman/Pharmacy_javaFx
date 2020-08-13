package Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dbDataBase {
    private static final String Database_URL = "jdbc:oracle:thin:@localhost:1521/orcl";
    private static final String Database_Pass = "Oracle_1";
    private static final String Database_Name = "system";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/orcl,system,Oracle_1";
    private static final String Jdbc_Driver = "oracle.jdbc.driver.OracleDriver";
    private static Connection con = null;


    public static Connection connect() {
        try {
            Class.forName(Jdbc_Driver);
            con = DriverManager.getConnection(Database_URL, Database_Name, Database_Pass);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    //################# Stock Data #################//
    public static ObservableList<stock> getDataStock() {
        Connection con = connect();
        ObservableList<stock> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("Select * from stock");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new stock(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }
            con.close();
        } catch (Exception e) {
            System.out.println("Exception in dbDataBase Stock");
        }
        return list;

    }
    //################# Stock Dop Down
    public static List<String> getStockNameColumn() {
        try {
            List<stock> li= getDataStock();

            List<String>  col = new ArrayList<String>();
            for(int i=0 ;i< li.size();i++)
            {
                col.add(li.get(i).getPRODUCT_Name());
            }
            return  col;
        } catch (Exception e) {

        }
        return null;
    }




    //################# Sales Data #################//
    public static ObservableList<sales> getDataSales() {
        Connection con = connect();
        ObservableList<sales> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("select * from sales");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new sales(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));

            }
            con.close();
        } catch (Exception e) {
        }

        return list;
    }
    //################# Sales Dop Down
    public static List<String> getSalesNameColumn() {
        try {
            List<sales> li= getDataSales();

            List<String>  col = new ArrayList<String>();
            for(int i=0 ;i< li.size();i++)
            {
                col.add(li.get(i).getPRODUCT_NAME());
            }
            return  col;
        } catch (Exception e) {

        }
        return null;
    }



    //################# Purchase Data   #################//
    public static ObservableList<purchase> getDataPurchase() {
        Connection conn = connect();
        ObservableList<purchase> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from purchase");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new purchase(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)
                        , rs.getString(9), rs.getString(10), rs.getString(11)));

            }
            conn.close();
        } catch (Exception e) {
        }
        return list;
    }
    //################# Purchase Dop Down
    public static List<String> getPurchaseNameColumn() {
        try {
            List<purchase> li= getDataPurchase();

            List<String>  col = new ArrayList<String>();
            for(int i=0 ;i< li.size();i++)
            {
                col.add(li.get(i).getProductName());
            }
            return  col;
        } catch (Exception e) {

        }
        return null;
    }




    //################# Company Data   #################//
    public static ObservableList<company> getDataCompany() {
        Connection con = connect();
        ObservableList<company> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("Select * from company");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new company(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;


    }
    //################# Company Dop Down
    public static List<String> getCompanyNameColumn() {
        try {
            List<company> li= getDataCompany();

            List<String>  col = new ArrayList<String>();
            for(int i=0 ;i< li.size();i++)
            {
                col.add(li.get(i).getCOMPANYNAME());
            }
            return  col;
        } catch (Exception e) {

        }
        return null;
    }




    //################# Employee Data   #################//
    public static ObservableList<employee> getDataEmployee() {
        Connection con = connect();
        ObservableList<employee> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = con.prepareStatement("Select * from EMP");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;


    }
    //################# Employee Dop Down
    public static List<String> getEmployeeNameColumn() {
        try {
            List<employee> li= getDataEmployee();

            List<String>  col = new ArrayList<String>();
            for(int i=0 ;i< li.size();i++)
            {
                col.add(li.get(i).getFirstName());
            }
            return  col;
        } catch (Exception e) {

        }
        return null;
    }




















}