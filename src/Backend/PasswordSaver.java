package Backend;

import java.io.*;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

//This class is in charge of holding a dictionary of passwords to urls
//This class is also in charge of saving passwords to an encrypted file
//Also loads the passwords from encrypted file on startup
public class PasswordSaver {

    HashMap<String, LoginInfo> loginTable = new HashMap<String, LoginInfo>();
    String secretKey = "TestSecretKey";
    String filePath = "./usr/data.dat";

    /* HASHMAP UPDATE */
    //Adds a password to the dictionary, if the password already exists, then update it
    private void AddPassword(String url, String alias, String username, String password){
        LoginInfo newEntry = new LoginInfo(alias, url, username, password, secretKey);

        loginTable.put(url, newEntry);

        // Save the login info after editing
        SaveLoginInfo();
    }

    // Removes a password given a URL to the website
    private void RemovePassword(String url){
        loginTable.remove(url);

        // Save the login info after removal
        SaveLoginInfo();
    }

    /* FILE IO */
    // Writes the login table to a file
    public void SaveLoginInfo(){
        try{
            FileOutputStream fos = new FileOutputStream(filePath, false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Write the blocks to the file
            oos.writeObject(loginTable);
            oos.close();
            fos.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // Loads the login table from a file
    public void LoadLoginInfo(){
        // Load file versions
        try {
            FileInputStream fis = new FileInputStream(filePath);	//Open the blocks file for reading
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Attempt to load our hashmap into this object
            loginTable = (HashMap<String, LoginInfo>) ois.readObject(); // Load the blocks into here
        } catch (FileNotFoundException e){
            // File not found, just return and keep our empty hashmap
            loginTable = new HashMap<String, LoginInfo>();
            return;
        } catch(EOFException e){
            return;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
