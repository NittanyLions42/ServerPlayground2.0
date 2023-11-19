import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    boolean registerUser(String userID, byte[] passcode)
    {
        return true;
    }

    boolean verifyCredentials(String userID, byte[] passcode)
    {
        return true;
    }

    private Connection connectToDB()
    {
        String url = "jdbc:mysql://localhost:3306/credentialbase";
        String username = "java";
        String password = "password";

        System.out.println("Connecting database ...");
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

}
