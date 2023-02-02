import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ZapytaniaSQL {
    public static ResultSet executeSelect(String selectQuery) {
        try {
            Connection connect = ConnectDB.connect();
            Statement statement = connect.createStatement();
            return statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            System.out.println("Zapytanie nie powiodło się");
        }
        return null;
    }

    public static void executeQuery(String query) {
        try {
            Connection connect = ConnectDB.connect();
            Statement statement = connect.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Zapytanie nie powiodło się");
        }
    }
}
