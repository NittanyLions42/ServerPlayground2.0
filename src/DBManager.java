import java.sql.*;
import java.util.Arrays;

public class DBManager {

    static void registerUser(String userID, byte[] passcode) throws IllegalStateException {
        String update = "INSERT INTO credentials(USERID, PASSCODE) VALUES ('" + userID + "', '" +
                Arrays.toString(passcode) + "');";
        try(Statement stmt = connectToDB().createStatement())
        {
            stmt.executeUpdate(update);
        }
        catch(SQLException e) {
            throw new IllegalStateException((e));
        }
    }

    static boolean verifyCredentials(String userID, byte[] passcode) throws IllegalStateException {
        String query = "SELECT PASSCODE FROM credentials WHERE USERID ='" + userID + "';";
        try(Statement stmt = connectToDB().createStatement())
        {
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            String actualCode = rs.getString("PASSCODE");
            return Arrays.toString(passcode).equals(actualCode);
        }
        catch(SQLException e) {
            throw new IllegalStateException((e));
        }
    }

    private static Connection connectToDB() throws SQLException
    {
        String url = "jdbc:mysql://localhost:3306/credentialbase";
        String username = "java";
        String password = "password";
        System.out.println("Connecting database ...");
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Database connected!");
        return connection;
    }

    public static void main(String[] args) throws IllegalStateException {
        String testUser = "ted";
        byte[] testData = new byte[8];
        for(int i = 0; i < 8; i++)
        {
            testData[i] =3;
        }
        registerUser(testUser, testData);
        if(verifyCredentials(testUser, testData))
        {
            System.out.println("It worked!");
        }
        else
        {
            System.out.println("It didn't work :(");
        }
    }
}
