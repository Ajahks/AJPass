package Backend.tb;

import Backend.PasswordCipher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

// We will be testing out the cipher here
public class CipherTB {

    public static void testGoodKey(){
        String secretKey = "wowowow69";
        String original = "longstorystudios.com";
        String encryptedKey = PasswordCipher.encrypt(original, secretKey);
        String decryptedKey = PasswordCipher.decrypt(encryptedKey, secretKey);

        System.out.println("Testing good key");
        System.out.println("Original: " + original);
        System.out.println("Encrypted: " +encryptedKey);
        System.out.println("Decrypted: " +decryptedKey);

        assertEquals(decryptedKey, original);
        assertNotEquals(encryptedKey, decryptedKey);

    }

    public static void testBadKey(){
        String secretKey = "wowowow69";
        String fakeKey = "wowowow99";
        String original = "longstorystudios.com";
        String encryptedKey = PasswordCipher.encrypt(original, secretKey);
        String decryptedKey = PasswordCipher.decrypt(encryptedKey, fakeKey);

        System.out.println("Testing bad key");
        System.out.println("Original: " + original);
        System.out.println("Encrypted: " +encryptedKey);
        System.out.println("Decrypted: " +decryptedKey);

        assertNotEquals(decryptedKey, original);
    }
}
