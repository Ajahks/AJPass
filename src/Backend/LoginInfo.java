package Backend;

import java.util.Hashtable;
import java.util.List;

// Data structure to hold the login information for the website
public class LoginInfo {
    Hashtable<String, String> info = new Hashtable<String,String>(); // This is where we will store the information

    LoginInfo(String alias, String url, String username, String password){
        info.put("alias", alias);
        info.put("url", url);

        // Encrypt the username and password
        
    }

}
