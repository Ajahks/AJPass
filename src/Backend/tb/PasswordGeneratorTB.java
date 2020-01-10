package Backend.tb;
import Backend.PasswordGenerator;

public class PasswordGeneratorTB {
    public static void main(String[] args) {
        //Instantiate a new PasswordGenerator
        PasswordGenerator passGen = new PasswordGenerator();

        System.out.println(passGen.genRandomPassword(8, true, false, false));
    }
}
