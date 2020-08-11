package controller.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class
purchaseTable {

    private static final String Database_URL="jdbc:oracle:thin:@localhost:1521/orcl";
    private static final String Database_Pass="Oracle_1";
    private static final String Database_Name="system";
    private static final String URL="jdbc:oracle:thin:@localhost:1521/orcl,system,Oracle_1";
    private static final String Jdbc_Driver ="oracle.jdbc.driver.OracleDriver";
    private static Connection con=null;


     private String  productID;




     private String  productName;
     private String  productCostPrice;
     private String  productSellingPrice;
     private String productExpiryDate;
     private String productProductionDate;
     private String  productPlace;
     private String  productPack;
     private String  productQuantity;
     private String productInStock;
     private String productCompanyID;


    public purchaseTable(String productID, String productName,  String productCostPrice, String productSellingPrice, String productExpiryDate, String productProductionDate, String productPlace, String productCompany, String productPack,String productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productCostPrice = productCostPrice;
        this.productSellingPrice = productSellingPrice;
        this.productExpiryDate = productExpiryDate;
        this.productProductionDate = productProductionDate;
        this.productPlace = productPlace;
        this.productCompanyID = productCompany;
        this.productPack = productPack;
        this.productQuantity = productQuantity;
    }

    public void setProductInStock(String productInStock) {
        this.productInStock = productInStock;
    }

    public purchaseTable() {
    }
    public String getId() {
        return productID;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }



    public String getProductCostPrice() {
        return productCostPrice;
    }

    public String getProductSellingPrice() {
        return productSellingPrice;
    }

    public String getProductExpiryDate() {
        return productExpiryDate;
    }

    public String getProductProductionDate() {
        return productProductionDate;
    }

    public String getProductPlace() {
        return productPlace;
    }

    public String getProductCompany() {
        return productCompanyID;
    }

    public String getProductPack() {
        return productPack;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public String getProductInStock() {
        return productInStock;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    public void setProductCostPrice(String productCostPrice) {
        this.productCostPrice = productCostPrice;
    }

    public void setProductSellingPrice(String productSellingPrice) {
        this.productSellingPrice = productSellingPrice;
    }

    public void setProductExpiryDate(String productExpiryDate) {
        this.productExpiryDate = productExpiryDate;
    }

    public void setProductProductionDate(String productProductionDate) {
        this.productProductionDate = productProductionDate;
    }

    public void setProductPlace(String productPlace) {
        this.productPlace = productPlace;
    }



    public void setProductPack(String productPack) {
        this.productPack = productPack;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }
    public void setProductCompanyID(String productCompanyID) {
        this.productCompanyID = productCompanyID;
    }


    public boolean addPurchase(){
         this.productInStock= String.valueOf( Double.parseDouble(this.productPack) * Double.parseDouble(this.productQuantity));
            try {
                Class.forName(Jdbc_Driver);
                con=DriverManager.getConnection(Database_URL,Database_Name,Database_Pass);

                PreparedStatement stmt = con.prepareStatement("INSERT INTO PURCHASE (PRODUCT_ID, P_NAME,COST_PRICE, SELLING_PRICE, EXPIRY_DATE, PRODUCTION_DATE, COMPANY_ID, PLACE, NO_PACK, Q_IN_ONEPACK, QUANTITY) VALUES (?,?,?,?, ? ,? , ?, ?, ?, ?,?)");
                stmt.setString(1,this.productID );
                stmt.setString(2, this.productName);
                stmt.setString(3, this.productCostPrice);
                stmt.setString(4,this.productSellingPrice );
                stmt.setString(5,this.productExpiryDate);
                stmt.setString(6,this.productProductionDate);
                stmt.setString(7,this.productCompanyID);
                stmt.setString(8,this.productPlace);
                stmt.setString(9,this.productPack);
                stmt.setString(10,this.productQuantity);
                stmt.setString(11,this.productInStock);

                int i = stmt.executeUpdate();
                System.out.println(i + " records inserted into PURCHASE  table ");
                con.close();
                return true;

            } catch (Exception e) {
                e.printStackTrace();

            }
            return false;
    }

    @Override
    public String toString() {
        return "purchaseTable{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", productCostPrice='" + productCostPrice + '\'' +
                ", productSellingPrice='" + productSellingPrice + '\'' +
                ", productExpiryDate='" + productExpiryDate + '\'' +
                ", productProductionDate='" + productProductionDate + '\'' +
                ", productPlace='" + productPlace + '\'' +
                ", productPack='" + productPack + '\'' +
                ", productQuantity='" + productQuantity + '\'' +
                ", productInStock='" + productInStock + '\'' +
                ", productCompanyID='" + productCompanyID + '\'' +
                '}';
    }

    public static ArrayList<purchaseTable> getAll(){
        ArrayList<purchaseTable> newPurchase =new ArrayList<>();
        try {
            Class.forName(Jdbc_Driver);
            con=DriverManager.getConnection(Database_URL,Database_Name,Database_Pass);
            String query="SELECT * FROM PURCHASE";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet result=ps.executeQuery();
            while (result.next()){
                purchaseTable purchase =new purchaseTable();
                purchase.setProductID(result.getString(1));
                purchase.setProductName(result.getString(2));
                purchase.setProductCostPrice(result.getString(3));
                purchase.setProductSellingPrice(result.getString(4));
                purchase.setProductExpiryDate(result.getString(5));
                purchase.setProductProductionDate(result.getString(6));
                purchase.setProductPlace(result.getString(7));
                purchase.setProductPack(result.getString(8));
                purchase.setProductQuantity(result.getString(9));
                purchase.setProductInStock(result.getString(10));
                purchase.setProductCompanyID(result.getString(11));
                newPurchase.add(purchase);

            }
            return newPurchase;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }




    }


}
