package Backend;

import java.util.Hashtable;

// Data structure to hold the login information for the website
public class LoginInfo implements java.io.Serializable{
    Hashtable<String, String> info = new Hashtable<String,String>(); // This is where we will store the information

    LoginInfo(String alias, String url, String username, String password, String secretKey){
        info.put("alias", alias);
        info.put("url", url);

        // Encrypt the username and password
        String encryptedUsername = PasswordCipher.encrypt("username", secretKey);
        info.put("username", encryptedUsername);

        String encryptedPassword = PasswordCipher.encrypt("username", secretKey);
        info.put("password", encryptedUsername);
    }

    // Grab the alias (will be used for display)
    public String GetAlias(){
        return info.get("alias");
    }

    // Grab the url
    public String GetUrl(){
        return info.get("url");
    }

    // Return the username given the secret key
    public String GetUsername(String secretKey){
        return PasswordCipher.decrypt(info.get("username"), secretKey);
    }

    // Return the password given the secretKey
    public String GetPassword(String secretKey){
        return PasswordCipher.decrypt(info.get("password"), secretKey);
    }

}
