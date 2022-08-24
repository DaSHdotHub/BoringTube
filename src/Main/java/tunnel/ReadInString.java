package Main.java.tunnel;
import java.util.Scanner;

public class ReadInString {
        static Scanner input = new Scanner(System.in);
        static String aString;

        public static String returnUserInput(){
            try {
                System.out.print(">");
                aString = input.nextLine();
            }
            catch (Exception e) {
                System.out.println("You did not enter a string");
                System.out.print("Please try again: ");
                aString = input.nextLine();
            }
            return aString;
        }
    }
