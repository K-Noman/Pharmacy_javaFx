package controller.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class stockTable {
    private static final String Database_URL = "jdbc:oracle:thin:@localhost:1521/orcl";
    private static final String Database_Pass = "Oracle_1";
    private static final String Database_Name = "system";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/orcl,system,Oracle_1";
    private static final String Jdbc_Driver = "oracle.jdbc.driver.OracleDriver";
    private static Connection con = null;


    private String PRODUCT_ID;
    private String PRODUCT_Name;
    private String Selling_Price;
    private String Company_ID;
    private String stock;

    public stockTable() {
    }

    public String getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(String PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getPRODUCT_Name() {
        return PRODUCT_Name;
    }

    public void setPRODUCT_Name(String PRODUCT_Name) {
        this.PRODUCT_Name = PRODUCT_Name;
    }

    public String getSelling_Price() {
        return Selling_Price;
    }

    public void setSelling_Price(String selling_Price) {
        Selling_Price = selling_Price;
    }

    public String getCompany_ID() {
        return Company_ID;
    }

    public void setCompany_ID(String company_ID) {
        Company_ID = company_ID;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "stockTable{" +
                "PRODUCT_ID='" + PRODUCT_ID + '\'' +
                ", PRODUCT_Name='" + PRODUCT_Name + '\'' +
                ", Selling_Price='" + Selling_Price + '\'' +
                ", Company_ID='" + Company_ID + '\'' +
                ", Classes.stock='" + stock + '\'' +
                '}';
    }


    public static ArrayList<stockTable> getAll() {
        ArrayList<stockTable> newStock = new ArrayList<>();
        try {
            Class.forName(Jdbc_Driver);
            con = DriverManager.getConnection(Database_URL, Database_Name, Database_Pass);
            String query = "SELECT * FROM STOCK";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                stockTable Stock = new stockTable();
                Stock.setPRODUCT_ID(result.getString(1));
                Stock.setPRODUCT_Name(result.getString(2));
                Stock.setSelling_Price(result.getString(3));
                Stock.setCompany_ID(result.getString(4));
                Stock.setStock(result.getString(5));
                newStock.add(Stock);

            }
            return newStock;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
