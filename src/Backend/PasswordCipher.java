package Backend;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//This class is used to encrypt a given password and return it
public class PasswordCipher {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(String myKey)
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //This method will encrypt a password
    public static String encrypt(String password, String secret){
        try{
            setKey(secret);


            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/ECB/PKCS5PADDING"); // Initialize the cipher to AES
            cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, secretKey); // Set up our cipher to encrypt using our secret key

            //Convert the encoding to a string and return that string
            return Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes("UTF-8")));
        }
        catch (Exception e){
            System.out.println("Error while encrypting: "+ e.toString());
        }

        return null;
    }

    public static String decrypt(String ciphertext, String secret){
        try{
            setKey(secret);

            //Initialize our cipher to AES and our secret key
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, secretKey);

            //Decrypt and return
            return new String(cipher.doFinal(Base64.getDecoder().decode(ciphertext)));
        }
        catch(Exception e){
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
