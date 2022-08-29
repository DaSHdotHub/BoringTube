package Main.java.tunnel.Methods;
import java.util.Scanner;

public class GetInput{
        static Scanner input = new Scanner(System.in);
        static String aString;
        static int  anInt;

        public static String UserInputString(){
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
        public static int UserInputInt(){
            try {
                System.out.print(">");
                anInt = input.nextInt();
            }
            catch (Exception e) {
                System.out.println("You did not enter a number");
                System.out.print("Please try again: ");
                anInt = input.nextInt();
        }
            return anInt;
    }
    }
