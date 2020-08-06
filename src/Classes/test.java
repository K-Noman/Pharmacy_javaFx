package classes;

import controller.login;

import java.sql.SQLException;
import java.sql.SQLOutput;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        login login=new login("noman","12345");
//        System.out.println(login.validateUser());
        login login1=new login("admin","admin");
        System.out.println(login1.validateAdmin());


    }




}
