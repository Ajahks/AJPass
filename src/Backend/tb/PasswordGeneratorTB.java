package Backend.tb;
import Backend.PasswordGenerator;

public class PasswordGeneratorTB {
    public static void main(String[] args) {
        //Instantiate a new PasswordGenerator
        PasswordGenerator passGen = new PasswordGenerator();

        //Generate some passwords here
        String passAll10 = passGen.genRandomPassword(10, true, true, true);
        String passAll20 = passGen.genRandomPassword(20, true, true, true);
        String passAll5 = passGen.genRandomPassword(5, true, true, true);
        String passLetters = passGen.genRandomPassword(10, true, false, false);
        String passNumbers = passGen.genRandomPassword(10, false, true, false);
        String passSpecial = passGen.genRandomPassword(10, false, false, true);
    }
}