package classes;

import java.sql.*;

public class database {
    private static final String Database_url = "jdbc:oracle:thin:@localhost:1521/orcl";
    private static final String Database_Username = "system";
    private static final String Database_Password = "Oracle_1";
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static Connection conn = null;

    public database() {
    }

    public static void dbConnect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Registered!");
        } catch (ClassNotFoundException var2) {
            System.out.println("Where is your Oracle JDBC Driver?");
        }

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "system", "Oracle_1");
            System.out.println("Connection Done");
        } catch (SQLException var1) {
            System.out.println("Connection Failed! Check output console" + var1);
        }

    }

    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed Successfully");
            }

        } catch (Exception var1) {
            throw var1;
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        dbConnect();
        Statement stmt = conn.createStatement();
        String query = "Select * from company";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String companyName = rs.getString("C_NAME");
            String Address = rs.getString("ADDRESS");
            String Phone = rs.getString("PHONE");
            System.out.println(companyName + " " + Address + " " + Phone);
        }

    }
}

