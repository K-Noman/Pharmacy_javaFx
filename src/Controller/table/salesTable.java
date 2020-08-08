package controller.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class salesTable {

    private static final String Database_URL="jdbc:oracle:thin:@localhost:1521/orcl";
    private static final String Database_Pass="Oracle_1";
    private static final String Database_Name="system";
    private static final String URL="jdbc:oracle:thin:@localhost:1521/orcl,system,Oracle_1";
    private static final String Jdbc_Driver ="oracle.jdbc.driver.OracleDriver";
    private static Connection con=null;

    private String PRODUCT_ID;
    private String DOSE;
    private String QUANTITY;
    private String PRICE;
    private String AMMONT;
    private String PRODUCT_NAME;


    public salesTable(String PRODUCT_ID, String DOSE, String QUANTITY, String PRICE, String AMMONT, String PRODUCT_NAME) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.DOSE = DOSE;
        this.QUANTITY = QUANTITY;
        this.PRICE = PRICE;
        this.AMMONT = AMMONT;
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public salesTable() {
    }

    @Override
    public String toString() {
        return "salesTable{" +
                "PRODUCT_ID='" + PRODUCT_ID + '\'' +
                ", DOSE='" + DOSE + '\'' +
                ", QUANTITY='" + QUANTITY + '\'' +
                ", PRICE='" + PRICE + '\'' +
                ", AMMONT='" + AMMONT + '\'' +
                ", PRODUCT_NAME='" + PRODUCT_NAME + '\'' +
                '}';
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(String PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getDOSE() {
        return DOSE;
    }

    public void setDOSE(String DOSE) {
        this.DOSE = DOSE;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getAMMONT() {
        return AMMONT;
    }

    public void setAMMONT(String AMMONT) {
        this.AMMONT = AMMONT;
    }
    public boolean addSale(){
        try {
            Class.forName(Jdbc_Driver);
            con= DriverManager.getConnection(Database_URL,Database_Name,Database_Pass);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO SALES(PRODUCT_ID, DOSE, QUANTITY, PRICE, AMMONT,PRODUCT_NAME) VALUES (?, ?, ?, ?, ?,?)");
            stmt.setString(1,this.PRODUCT_ID );
            stmt.setString(2, this.DOSE);
            stmt.setString(3, this.QUANTITY);
            stmt.setString(4,this.PRICE );
            stmt.setString(5,this.AMMONT);
            stmt.setString(6,this.PRODUCT_NAME);
            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted into Sales  table ");
            con.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    public static ArrayList<salesTable> getAll(){
            ArrayList<salesTable>  newSalesTable=new ArrayList<>();
        try {
            Class.forName(Jdbc_Driver);
            con=DriverManager.getConnection(Database_URL,Database_Name,Database_Pass);
            String query="SELECT * FROM sales";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet result=ps.executeQuery();
            while (result.next()){
                salesTable sales =new salesTable();
                sales.setPRODUCT_ID(result.getString(1));
                sales.setDOSE(result.getString(2));
                sales.setQUANTITY(result.getString(3));
                sales.setPRICE(result.getString(4));
                sales.setAMMONT(result.getString(5));
                sales.setPRODUCT_NAME(result.getString(6));
                newSalesTable.add(sales);


            }
            return newSalesTable;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }









    }













}
