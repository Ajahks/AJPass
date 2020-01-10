package Backend;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//This class can generate passwords and return them
public class PasswordGenerator {

    //The letters that the generator can choose from
    private String[] letters = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"};

    //The numbers that the generator can choose from
    private String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    //The special characters that the generator can choose from
    private String[] specials = {"~", "!", "@", "$", "%", "^", "&", "*", "(", ")", "-", "+", "_", "=", "[", "]", "{", "}", ",", "<", ".", ">", "?"};

    private Random rand;

    //Constructor will initialize the rand object
    public PasswordGenerator(){
        //Seed the random with the current date and time to be unique
        rand = new Random(System.currentTimeMillis());
    }

    //Generates a random password using a mixture of numbers, special characters, and letters
    //length: the length of the password to generate
    public String genRandomPassword(int length, boolean useLetter, boolean useNumber, boolean useSpecial){
        String password = "";
        //generate the password here by generating enough random characters to fill the length
        for(int i = 0; i < length; i++){
            password += genRandomChar(useLetter, useNumber, useSpecial);
        }

        return password;
    }

    //return a random character based on the preferences
    private String genRandomChar(boolean useLetter, boolean useNumber, boolean useSpecial){
        List<String> possibleChars = new ArrayList<>();
        if(useLetter){
            possibleChars.add("letter");
        }
        if(useNumber){
            possibleChars.add("number");
        }
        if(useSpecial){
            possibleChars.add("special");
        }

        //if all the characters are empty, then return an empty string
        if(possibleChars.size() == 0){
            return "";
        }

        //Now generate a random number that corresponds to the size of the list
        String randomCategory = possibleChars.get(rand.nextInt(possibleChars.size()));

        //Check the random category and generate a string based on that category
        String generatedChar = "";
        switch(randomCategory){
            case "letter":
                generatedChar = getRandomLetter();
                break;
            case "number":
                generatedChar = getRandomNum();
                break;
            case "special":
                generatedChar = getRandomSpecial();
                break;
            default:
                System.out.print("Invalid character type");
        }

        return generatedChar;
    }

    //returns a random letter
    private String getRandomLetter(){
        String randomLetter = letters[rand.nextInt(letters.length)];
        return randomLetter;
    }

    //returns a random number
    private String getRandomNum(){
        String randomNum = numbers[rand.nextInt(numbers.length)];
        return randomNum;
    }

    //returns a random special character
    private String getRandomSpecial(){
        String randomSpecial = specials[rand.nextInt(numbers.length)];
        return randomSpecial;
    }
}
