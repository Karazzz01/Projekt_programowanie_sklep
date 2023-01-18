import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static String DBLink = "jdbc:mysql://localhost:3306/programowanie_baza";
    private static String DBLogin = "root";
    private static String DBPass = "";

    public static Connection connect() {

        Connection connectDB = null;

        try {
            connectDB = DriverManager.getConnection(DBLink, DBLogin, DBPass);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Brak połączenia");
        }
        return connectDB;
    }
}
