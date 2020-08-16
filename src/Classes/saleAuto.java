package Classes;

public class saleAuto {

    private String PRODUCT_NAME;


    public saleAuto(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    @Override
    public String toString() {
        return "saleAuto{" +
                "PRODUCT_NAME='" + PRODUCT_NAME + '\'' +
                '}';
    }





}
