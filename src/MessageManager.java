import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class MessageManager {
    private final String password = "rumbleHouse";
    private final byte[] salt = new byte[8];
    private final SecretKey secret;

    MessageManager() throws NoSuchAlgorithmException {
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("AES-256");
            char[] cPass = password.toCharArray();

            KeySpec spec = new PBEKeySpec(cPass, salt, 256, 256);
            secret = factory.generateSecret(spec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }


    }

    private String decrypt (String data) throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance("AES-256");
        return data;
    }

    private byte[] encrypt (String data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES-256");
            cipher.init(Cipher.ENCRYPT_MODE, secret);
            AlgorithmParameters params = cipher.getParameters();
            return cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }
}
