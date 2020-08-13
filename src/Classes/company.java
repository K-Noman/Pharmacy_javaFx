package Classes;

public class company {
    private String COMPANY_ID;
    private String COMPANYNAME;
    private String COMPANYADDRESS;
    private String COMPANYPHONE;

    public company() {
    }

    public company(String COMPANY_ID, String COMPANYNAME, String COMPANYADDRESS, String COMPANYPHONE) {
        this.COMPANY_ID = COMPANY_ID;
        this.COMPANYNAME = COMPANYNAME;
        this.COMPANYADDRESS = COMPANYADDRESS;
        this.COMPANYPHONE = COMPANYPHONE;
    }


    @Override
    public String toString() {
        return "company{" +
                "COMPANY_ID='" + COMPANY_ID + '\'' +
                ", COMPANYNAME='" + COMPANYNAME + '\'' +
                ", COMPANYADDRESS='" + COMPANYADDRESS + '\'' +
                ", COMPANYPHONE='" + COMPANYPHONE + '\'' +
                '}';
    }

    public String getCOMPANY_ID() {
        return COMPANY_ID;
    }

    public void setCOMPANY_ID(String COMPANY_ID) {
        this.COMPANY_ID = COMPANY_ID;
    }

    public String getCOMPANYNAME() {
        return COMPANYNAME;
    }

    public void setCOMPANYNAME(String COMPANYNAME) {
        this.COMPANYNAME = COMPANYNAME;
    }

    public String getCOMPANYADDRESS() {
        return COMPANYADDRESS;
    }

    public void setCOMPANYADDRESS(String COMPANYADDRESS) {
        this.COMPANYADDRESS = COMPANYADDRESS;
    }

    public String getCOMPANYPHONE() {
        return COMPANYPHONE;
    }

    public void setCOMPANYPHONE(String COMPANYPHONE) {
        this.COMPANYPHONE = COMPANYPHONE;
    }


}

