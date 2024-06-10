package myLibrary;
import java.sql.Connection;
import myLibrary.util.DatabaseUtil;


public class TestDatabaseConnection {
    public static void main(String[] args) {
        Connection connection = DatabaseUtil.getConnection();
        if (connection != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Failed to connect.");
        }
    }
}

