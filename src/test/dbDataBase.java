//package test;
//
//import Classes.stock;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public class dbDataBase {
//    private static final String Database_URL = "jdbc:oracle:thin:@localhost:1521/orcl";
//    private static final String Database_Pass = "Oracle_1";
//    private static final String Database_Name = "system";
//    private static final String URL = "jdbc:oracle:thin:@localhost:1521/orcl,system,Oracle_1";
//    private static final String Jdbc_Driver = "oracle.jdbc.driver.OracleDriver";
//    private static Connection con = null;
//
//
//    public static Connection connect() {
//        try {
//            Class.forName(Jdbc_Driver);
//            con = DriverManager.getConnection(Database_URL, Database_Name, Database_Pass);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return con;
//    }
//
//    public static ObservableList<sales> getDataSales(){
//        Connection conn = connect();
//        ObservableList<sales> list = FXCollections.observableArrayList();
//        try {
//            PreparedStatement ps = conn.prepareStatement("select * from sales");
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()){
//                list.add(new sales(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6)));
//
//            }conn.close();
//        } catch (Exception e) {
//        }
//
//        return list;
//    }
//
//   public static ObservableList<stock> getDataStock(){
//        Connection con=connect();
//        ObservableList<stock> list=FXCollections.observableArrayList();
//        try {
//            PreparedStatement ps=con.prepareStatement("Select * from stock");
//            ResultSet rs=ps.executeQuery();
//            while (rs.next()){
//                list.add(new  stock(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
//
//            }con.close();
//        }catch (Exception e){
//            System.out.println("Exception in dbDataBase Stock");
//        }
//        return list;
//
//
//   }
//
//
//
//
//
//
//
//
//
//
//
//
//
//}