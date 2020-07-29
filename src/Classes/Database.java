package Classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database {
    private static final String Database_url = "jdbc:oracle:thin:@localhost:1521/orcl";
    private static final String Database_Username = "system";
    private static final String Database_Password = "Oracle_1";
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static Connection conn = null;


    public static void dbConnect() throws SQLException, ClassNotFoundException {
        //Setting Oracle JDBC Driver
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Oracle JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
        }
        //Establish the Oracle Connection using Connection String
        try {
            conn = DriverManager.getConnection(Database_url, Database_Username, Database_Password);
            System.out.println("Connection Done");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
        }
    }

    //Close Connection
    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection closed Successfully");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}