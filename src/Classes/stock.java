package Classes;

public class stock {

    private String PRODUCT_ID;
    private String PRODUCT_Name;
    private String Selling_Price;
    private String Company_ID;
    private String stock;

    public stock() {

    }

    @Override
    public String toString() {
        return "stock{" +
                "PRODUCT_ID='" + PRODUCT_ID + '\'' +
                ", PRODUCT_Name='" + PRODUCT_Name + '\'' +
                ", Selling_Price='" + Selling_Price + '\'' +
                ", Company_ID='" + Company_ID + '\'' +
                ", stock='" + stock + '\'' +
                '}';
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

    public stock(String PRODUCT_ID, String PRODUCT_Name, String selling_Price, String company_ID, String stock) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_Name = PRODUCT_Name;
        Selling_Price = selling_Price;
        Company_ID = company_ID;
        this.stock = stock;
    }
}
