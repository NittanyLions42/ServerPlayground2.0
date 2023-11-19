import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityManager {

    private String output;

    SecurityManager(String input) {
        MessageDigest md;
        try
        {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException nsae)
        {
            throw new RuntimeException("Error: " + nsae.getMessage());
        }
        byte[] outputByteArray = md.digest(input.getBytes());
        printUTFCharArray(outputByteArray); //size of SHA-256 return.

//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(outputByteArray);
//        output = stringBuilder.toString();
//        System.out.println(output);
    }

    private void printUTFCharArray(byte[] input)
    {
        System.out.println("This is a placeholder so we can read the byte[] array.\n");
    }
}
