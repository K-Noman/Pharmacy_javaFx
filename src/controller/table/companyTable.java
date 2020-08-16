package controller.table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class companyTable {
    private static final String Database_URL="jdbc:oracle:thin:@localhost:1521/orcl";
    private static final String Database_Pass="Oracle_1";
    private static final String Database_Name="system";
    private static final String URL="jdbc:oracle:thin:@localhost:1521/orcl,system,Oracle_1";
    private static final String Jdbc_Driver ="oracle.jdbc.driver.OracleDriver";
    private static Connection con=null;


    private String COMPANY_ID;
    private String COMPANYNAME;
    private String COMPANYADDRESS;
    private String COMPANYPHONE;


    public companyTable(String COMPANY_ID, String COMPANYNAME, String COMPANYADDRESS, String COMPANYPHONE) {
        this.COMPANY_ID = COMPANY_ID;
        this.COMPANYNAME = COMPANYNAME;
        this.COMPANYADDRESS = COMPANYADDRESS;
        this.COMPANYPHONE = COMPANYPHONE;
    }

    public companyTable() {

    }


    @Override
    public String toString() {
        return "companyTable{" +
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

    public boolean addCompany(){

        try {
            Class.forName(Jdbc_Driver);
            con= DriverManager.getConnection(Database_URL,Database_Name,Database_Pass);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO COMPANY (COMPANY_ID, COMPANYNAME, COMPANYADDRESS, COMPANYPHONE) VALUES (?, ?, ?, ?)");
            stmt.setString(1,this.COMPANY_ID);
            stmt.setString(2, this.COMPANYNAME);
            stmt.setString(3, this.COMPANYADDRESS);
            stmt.setString(4,this.COMPANYPHONE);
            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted into Company  table ");
            con.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    public static ArrayList<companyTable> getAll(){
        ArrayList<companyTable> newCompany =new ArrayList<>();
        try {
            Class.forName(Jdbc_Driver);
            con=DriverManager.getConnection(Database_URL,Database_Name,Database_Pass);
            String query="SELECT * FROM Company";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet result=ps.executeQuery();
            while (result.next()){
                companyTable company =new companyTable();
                company.setCOMPANY_ID(result.getString(1));
                company.setCOMPANYNAME(result.getString(2));
                company.setCOMPANYADDRESS(result.getString(3));
                company.setCOMPANYPHONE(result.getString(4));
                newCompany.add(company);

            }
            return newCompany;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }




    }





}