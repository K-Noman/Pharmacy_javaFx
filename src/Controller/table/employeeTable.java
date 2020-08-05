package controller.table;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;

public class employeeTable {
    private String id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String password;
    private static final String Database_URL="jdbc:oracle:thin:@localhost:1521/orcl";
    private static final String Database_Pass="Oracle_1";
    private static final String Database_Name="system";
    private static final String URL="jdbc:oracle:thin:@localhost:1521/orcl,system,Oracle_1";
    private static final String Jdbc_Driver ="oracle.jdbc.driver.OracleDriver";
    private static Connection con=null;

    public employeeTable(String id, String firstName, String lastName, String mobile, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    public employeeTable() {

    }

    @Override
    public String toString() {
        return "addEmployee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean saveEmployee() {
        try {
            Class.forName(Jdbc_Driver);
            con=DriverManager.getConnection(Database_URL,Database_Name,Database_Pass);

            PreparedStatement stmt = con.prepareStatement("insert into Emp values(?,? ,?,?,?,?)");
            stmt.setString(1, this.id);
            stmt.setString(2, this.firstName);
            stmt.setString(3, this.lastName);
            stmt.setString(4, this.mobile);
            stmt.setString(5, this.mobile);
            stmt.setString(6, this.password);
            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted into EMP table ");
            con.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();

        }return false;

    }

    public static ArrayList<employeeTable> getAll(){
        ArrayList<employeeTable> employee=new ArrayList<>();
        try {
            Class.forName(Jdbc_Driver);
            con=DriverManager.getConnection(Database_URL,Database_Name,Database_Pass);
            String query="SELECT * FROM EMP";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet result=ps.executeQuery();
            while (result.next()){
                employeeTable employeeRec=new employeeTable();
                employeeRec.setId(result.getString(1));
                employeeRec.setFirstName(result.getString(2));
                employeeRec.setLastName(result.getString(3));
                employeeRec.setMobile(result.getString(4));
                employeeRec.setEmail(result.getString(5));
                employeeRec.setPassword(result.getString(6));
                employee.add(employeeRec);

            }
            return employee;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;




    }


}
