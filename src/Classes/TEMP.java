package Classes;

public class TEMP {
    private String NAME;
    private String QUANTITY;
    private String TOTAL;


    @Override
    public String toString() {
        return "TEMP{" +
                "NAME='" + NAME + '\'' +
                ", QUANTITY='" + QUANTITY + '\'' +
                ", TOTAL='" + TOTAL + '\'' +
                '}';
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(String TOTAL) {
        this.TOTAL = TOTAL;
    }

    public TEMP(String NAME, String QUANTITY, String TOTAL) {
        this.NAME = NAME;
        this.QUANTITY = QUANTITY;
        this.TOTAL = TOTAL;
    }
}
