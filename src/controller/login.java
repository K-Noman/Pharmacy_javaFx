package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login {
    private static final String Database_URL="jdbc:oracle:thin:@localhost:1521/orcl";
    private static final String Database_Pass="Oracle_1";
    private static final String Database_Name="system";
    private static final String URL="jdbc:oracle:thin:@localhost:1521/orcl,system,Oracle_1";
    private static final String Jdbc_Driver ="oracle.jdbc.driver.OracleDriver";
    private static Connection con=null;

    private String Name;
    private String Password;


    public login(String name, String password) {
       this.Name = name;
        this.Password = password;
    }

    public String validateUser(){
        try {
            Class.forName(Jdbc_Driver);
            con= DriverManager.getConnection(Database_URL,Database_Name,Database_Pass);
            String query="SELECT USER_NAME , USER_PASSWORD FROM USERS WHERE USER_NAME=? AND USER_PASSWORD=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,this.Name);
            ps.setString(2,this.Password);
            ResultSet result=ps.executeQuery();
            if (result.next()){
                return "user.fxml";
            }
            Aller("invalid Login ");
            return "no Login in";

        }catch (Exception e){
            e.printStackTrace();
            return "no LOgin";
        }

    }

    public  String validateAdmin(){
        try {
            Class.forName(Jdbc_Driver);
            con= DriverManager.getConnection(Database_URL,Database_Name,Database_Pass);
            System.out.println(this.Name);
            System.out.println(this.Password);
            String queryA="SELECT ADMIN_NAME , ADMIN_PASSWORD FROM P_ADMIN WHERE ADMIN_NAME=? AND ADMIN_PASSWORD=? ";
            PreparedStatement psA=con.prepareStatement(queryA);
            psA.setString(1,this.Name);
            psA.setString(2,this.Password);
            ResultSet resultA=psA.executeQuery();
            if (resultA.next()){
//                return "admin.fxml";
                return "admin.fxml";
            }
            Aller("invalid Login ");
            return "admin.fxml Npt any";

        }catch (Exception e){
            e.printStackTrace();
            return "No admin login";
        }


    }
    private static void Aller(String title){
        Alert alert = new Alert(Alert.AlertType.ERROR, "UserName or Password is in correct \n please enter the valid data"
                , ButtonType.CLOSE);
        alert.setHeaderText("Error");
        alert.setTitle(title);
        alert.show();


    }







}
