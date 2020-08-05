package test;

import java.sql.*;
import java.util.ArrayList;

public class testTable {
    private static final String Database_URL="jdbc:oracle:thin:@localhost:1521/orcl";
    private static final String Database_Pass="Oracle_1";
    private static final String Database_Name="system";
    private static final String URL="jdbc:oracle:thin:@localhost:1521/orcl,system,Oracle_1";
    private static final String Jdbc_Driver ="oracle.jdbc.driver.OracleDriver";
    private static Connection connection=null;

    @Override
    public String toString() {
        return "testTable{" +
                "cName='" + cName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    private String cName;
    private String address;
    private String phone;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public testTable(String cName, String address, String phone) {
        this.cName = cName;
        this.address = address;
        this.phone = phone;
    }

    public testTable() {


    }

    public void save() {

        try {

            Class.forName(Jdbc_Driver);
//            connection=DriverManager.getConnection(Database_URL,Database_Name,Database_Pass);
            connection=DriverManager.getConnection(URL);
            String query="INSERT INTO company(C_NAME,ADDRESS,PHONE) values(?,?,?)";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,this.cName);
            ps.setString(2,this.address);
            ps.setString(3,this.phone);
            ps.executeUpdate();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static ArrayList<testTable> getAll(){
        ArrayList<testTable> employee =new ArrayList<>();

        try {
            Class.forName(Jdbc_Driver);
            connection=DriverManager.getConnection(Database_URL,Database_Name,Database_Pass);
            String query="Select * FROM EMP";
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet result=ps.executeQuery();
            while (result.next()){
                testTable emp=new testTable();
                emp.setcName(result.getString(1));
                emp.setAddress(result.getString(2));
                emp.setPhone(result.getString(3));
                employee.add(emp);

            }
            return employee;

        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }






}
