package Classes;

public class purchase {
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

    public purchase(String productID, String productName, String productCostPrice, String productSellingPrice, String productExpiryDate, String productProductionDate, String productPlace, String productPack, String productQuantity, String productInStock, String productCompanyID) {
        this.productID = productID;
        this.productName = productName;
        this.productCostPrice = productCostPrice;
        this.productSellingPrice = productSellingPrice;
        this.productExpiryDate = productExpiryDate;
        this.productProductionDate = productProductionDate;
        this.productPlace = productPlace;
        this.productPack = productPack;
        this.productQuantity = productQuantity;
        this.productInStock = productInStock;
        this.productCompanyID = productCompanyID;
    }

    @Override
    public String toString() {
        return "purchase{" +
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

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCostPrice() {
        return productCostPrice;
    }

    public void setProductCostPrice(String productCostPrice) {
        this.productCostPrice = productCostPrice;
    }

    public String getProductSellingPrice() {
        return productSellingPrice;
    }

    public void setProductSellingPrice(String productSellingPrice) {
        this.productSellingPrice = productSellingPrice;
    }

    public String getProductExpiryDate() {
        return productExpiryDate;
    }

    public void setProductExpiryDate(String productExpiryDate) {
        this.productExpiryDate = productExpiryDate;
    }

    public String getProductProductionDate() {
        return productProductionDate;
    }

    public void setProductProductionDate(String productProductionDate) {
        this.productProductionDate = productProductionDate;
    }

    public String getProductPlace() {
        return productPlace;
    }

    public void setProductPlace(String productPlace) {
        this.productPlace = productPlace;
    }

    public String getProductPack() {
        return productPack;
    }

    public void setProductPack(String productPack) {
        this.productPack = productPack;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductInStock() {
        return productInStock;
    }

    public void setProductInStock(String productInStock) {
        this.productInStock = productInStock;
    }

    public String getProductCompanyID() {
        return productCompanyID;
    }

    public void setProductCompanyID(String productCompanyID) {
        this.productCompanyID = productCompanyID;
    }
}






