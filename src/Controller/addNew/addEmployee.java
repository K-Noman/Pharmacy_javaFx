package controller.addNew;

import java.sql.*;

public class addEmployee {
    private String id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String password;
    public addEmployee(String firstName, String lastName, String mobile, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    public addEmployee(String id, String firstName, String lastName, String mobile, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
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

    public addEmployee save() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "system", "Oracle_1");

            PreparedStatement stmt = con.prepareStatement("insert into Emp values(?,? ,?,?,?,?)");
            stmt.setString(1, this.id);
            stmt.setString(2, this.firstName);
            stmt.setString(3, this.lastName);
            stmt.setString(4, this.mobile);
            stmt.setString(5, this.mobile);
            stmt.setString(6, this.password);

            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted in employee table ");
            con.close();
            return this;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

}



