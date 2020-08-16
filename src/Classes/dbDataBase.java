package Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.controlsfx.control.Notifications;

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
            List<stock> li = getDataStock();

            List<String> col = new ArrayList<String>();
            for (int i = 0; i < li.size(); i++) {
                col.add(li.get(i).getPRODUCT_Name());
            }
            return col;
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
    public static ObservableList<saleAuto> getForAutoDataSales() {
        Connection con = connect();
        ObservableList<saleAuto> list = FXCollections.observableArrayList();
        try {

            String query ="  select distinct product_name from sales where dose='1'  " ;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                list.add(new saleAuto(rs.getString("PRODUCT_NAME")));
            }
            con.close();
        } catch (Exception e) {
        }

        return list;
    }
    //################# Sales Dop Down
    public static List<String> getSalesNameColumn() {
        try {
            List<saleAuto> li = getForAutoDataSales();

            List<String> col = new ArrayList<String>();
            for (int i = 0; i < li.size(); i++) {
                col.add(li.get(i).getPRODUCT_NAME());
            }
            return col;
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
            List<purchase> li = getDataPurchase();

            List<String> col = new ArrayList<String>();
            for (int i = 0; i < li.size(); i++) {
                col.add(li.get(i).getProductName());
            }
            return col;
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
            List<company> li = getDataCompany();

            List<String> col = new ArrayList<String>();
            for (int i = 0; i < li.size(); i++) {
                col.add(li.get(i).getCOMPANYNAME());
            }
            return col;
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
            List<employee> li = getDataEmployee();

            List<String> col = new ArrayList<String>();
            for (int i = 0; i < li.size(); i++) {
                col.add(li.get(i).getFirstName());
            }
            return col;
        } catch (Exception e) {

        }
        return null;
    }


    //################# TEMP Data   #################//
    public static ObservableList<TEMP> getDataTEMP() {

        ObservableList<TEMP> list = FXCollections.observableArrayList();
        try {
            Connection con = connect();
            PreparedStatement ps = con.prepareStatement("Select * from TEMP");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new TEMP(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;


    }
    //################# TEMP Name Down
    public static List<String> getTEMPNameColumn() {
        try {
            List<TEMP> li = getDataTEMP();

            List<String> col = new ArrayList<String>();
            for (int i = 0; i < li.size(); i++) {
                col.add(li.get(i).getNAME());
            }
            return col;
        } catch (Exception e) {

        }
        return null;
    }
    //################# TEMP Quantity Down
    public static List<String> getTEMPQuantityColumn() {
        try {
            List<TEMP> li = getDataTEMP();

            List<String> col = new ArrayList<String>();
            for (int i = 0; i < li.size(); i++) {
                col.add(li.get(i).getQUANTITY());
            }
            return col;
        } catch (Exception e) {

        }
        return null;
    }
    //################# Insert into TEMP   #################//
    public static boolean insertIntoTemp(String name, String quantity, double total) {
        try {
            Connection con = connect();

            PreparedStatement stmt = con.prepareStatement("insert into TEMP (NAME, QUANTITY, TOTAL) values(?,? ,?)");
            stmt.setString(1, name);
            stmt.setString(2, quantity);
            stmt.setDouble(3, total);

            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted into TEMP table ");
            con.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;


    }
    public static void removeItem() {


        try {
            Connection connection = connect();
            PreparedStatement stmt = connection.prepareStatement("truncate table TEMP");

            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    //################# TEMP Total Down
    public static String getTEMPTotalColumn() {
        try {
            Connection con = connect();
            PreparedStatement st = con.prepareStatement("SELECT SUM(TOTAL ) from temp");
            ResultSet rs = st.executeQuery();
            String s = null;

            if (rs.next()) {
                s = rs.getString(1);
            }

            return s;


        } catch (Exception e) {

        }
        return null;
    }




    //################# FIND STOCK   #################//
    public static String findStock(String with) {
        Connection con = connect();
        String record = new String();
        try {


            String sComplete = with.trim() + "%";
//            PreparedStatement ps = con.prepareStatement("select "+toFind+" from " +tableName+ " where "+with+" LIKE ? ");
            PreparedStatement ps = con.prepareStatement("select stock from stock where Product_name like ? ");
            ps.setString(1, sComplete);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                record = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;
    }
    //################# FIND SellingPrice   #################//
    public static String findSellingPrice(String Product_ID) {
        Connection con = connect();
        String record = new String();
        try {


            String sComplete = Product_ID.trim();
            PreparedStatement ps = con.prepareStatement("select selling_price from stock where product_ID= ? ");
            ps.setString(1, sComplete);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                record = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;
    }
    //################# FIND ID   #################//
    public static String findSearchID(String name) {
        Connection con = connect();
        String s = new String();
        try {
            String sp = name + "%";
            PreparedStatement ps = con.prepareStatement("select product_ID from Stock where PRODUCT_NAME LIKE ? ");
            ps.setString(1, sp);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s = rs.getString(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }




    //################# Insert into Sales   #################//
    public static boolean insertIntoSales(String id, String name, String quantity, String price, String bill) {
        try {
            Connection con = connect();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Sure insert into sales ", ButtonType.OK);
            alert.setHeaderText("CONFIRMATION");
            alert.setTitle("CONFIRMATION");
            alert.show();

            PreparedStatement stmt = con.prepareStatement("INSERT INTO SALES(PRODUCT_ID,  QUANTITY, PRICE, AMMONT,PRODUCT_NAME) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, id);
            stmt.setString(2, quantity);
            stmt.setString(3, price);
            stmt.setString(4, bill);
            stmt.setString(5, name);
            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted into Sales  table from User ");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            Aller("Sales");

        }
        return false;

    }
    public static String findNumberOfSAles(String name) {
        String s = null;
        Connection con = connect();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM sales WHERE product_NAME = ? ");
            stmt.setString(1, name);
            ResultSet re = stmt.executeQuery();
            if (re.next()) {
                s = re.getString(1);
            }
            return s;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;


    }
    public static String findSaleAmount(String name) {
        String s = null;
        Connection con = connect();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT SUM(quantity ) from sales Where product_NAME = ?  ");
            stmt.setString(1, name);
            ResultSet re = stmt.executeQuery();
            if (re.next()) {
                s = re.getString(1);
            }
            return s;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String findRevinue(String name) {
        String s = null;
        Connection con = connect();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT SUM(ammont ) from sales Where product_NAME = ?  ");
            stmt.setString(1, name);
            ResultSet re = stmt.executeQuery();
            if (re.next()) {
                s = re.getString(1);
            }
            return s;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    // ############## Update Purchase
    public static void updatePurchase(String id,String quantity) {
        try {
            Connection con = connect();
            String query =" UPDATE PURCHASE SET QUANTITY ="+quantity+" WHERE product_id=" +id ;
            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            System.out.println("updated purchase");
            con.close();
            Notifications.create().text("Data updated to Purchase").showConfirm();
        } catch (Exception e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            Notifications.create().text("Data NOT updated to Purchase").showWarning();

        }
    }
    // ############## Update Employee
    public static void updateEmployee(String empid, String firstname, String lastname, String mobile,  String password) {
        try {
            Connection con = connect();
            String query =" update EMP SET firstname='"+firstname+"' ,lastname='"+lastname+"',mobile='"+mobile+"',password='"+password+"' where empid="+empid ;
            Statement statement=con.createStatement();
            ResultSet resultSet=statement.executeQuery(query);

            con.close();
            System.out.println("updated EMP");
            Notifications.create().text("Data updated to Employee").showConfirm();
        } catch (Exception e) {
            System.out.println("Problem occurred at executeUpdate operation EMP : " + e);
            Notifications.create().text("Data NOT updated to Employee").showWarning();

        }






    }



    private static void Aller(String title){
    Alert alert = new Alert(Alert.AlertType.ERROR, "Date not operated \n Please put the correct data in the fields"
            , ButtonType.CLOSE);
    alert.setHeaderText("Error");
    alert.setTitle(title);
    alert.show();


}


}

