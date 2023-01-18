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
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void executeQuery(String query) {
        try {
            Connection connect = ConnectDB.connect();
            Statement statement = connect.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
