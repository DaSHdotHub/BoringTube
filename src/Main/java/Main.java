package Main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        OutputInfo();

        //Analyze Input
        /*  First condition: number of signs <= 50000
            Second condition: number of phone <= 1000
            Third condition: input parameter 'x' and '-'
            */
        boolean aFirstCondition = false;
        boolean aSecondCondition = false;
        boolean aThirdCondition = false;
        boolean doNotExitLoop = true;
        char[] tunnelParts;
        do {
            tunnelParts = readInString().toLowerCase().toCharArray();

            if (tunnelParts.length <= 50000) {
                aFirstCondition = true;
            } else {
                System.out.println("string has too many values, please try again");
            }

            int counter = 0;
            for (char aChar : tunnelParts) {
                if (aChar == 'x') counter++;
            }
            if (counter < 1000) {
                aSecondCondition = true;
            } else {
                System.out.println("string has too many 'X' values, please try again");
            }
            int counterWrongChars = 0;
            for (char aChar : tunnelParts) {
                if (aChar != 'x' && aChar != '-') {
                    counterWrongChars++;
                }
            }
            if (counterWrongChars != 0) {
                System.out.println("string has wrong input, try '-' or 'x' for tunnelparts with a phone:");
            } else {
                aThirdCondition = true;
            }
            if (aFirstCondition && aSecondCondition && aThirdCondition ) {
                doNotExitLoop = false;
            }

        } while (doNotExitLoop);

        //Analyze Array
        /*  First condition: If nearer to exit as to phone, choose phone.
            Second condition: If two phone in equal distance, choose phone which is nearer to exit.
            Third condition: If second condition cannot be made, choose 'Mallorca'
            Output: 'Barcelona', 'Telefon', 'Mallorca'
            */


        //Process user input
        boolean aFourthCondition = true;
        do {
            int accident;
            System.out.println("Unfall an Stelle:");
            try{
                accident = Integer.parseInt(readInString());
            }
            catch (Exception e) {
                System.out.println("You did not enter a number\nPlease try again:\n");
                accident = Integer.parseInt(readInString());
            }
            if (accident < 0 || accident >= tunnelParts.length) {
                System.out.println("Unfall ausserhalb des Tunnels, weiterer Unfall?");
            } else {
                aFourthCondition = false;
            }
        }
        while(aFourthCondition);




    }

    public static void OutputInfo() {
        System.out.println("Type in a value for each part of the tunnel (max. 500000), parts with 'X' anzeigt, dass es in diesem Abschnitt ein Telefon gibt, und '-',\n" +
                " dass es kein Telefon gibt. Das erste Zeichen steht für den Abschnitt Barcelona (Pos = 0).");
    }

    public static String readInString() {
        Scanner input = new Scanner(System.in);
        String aString;
        try {
            System.out.print(">");
            aString = input.nextLine();
        }
        catch (InputMismatchException e) {
            System.out.println("You did not enter a string");
            System.out.print("Please try again: ");
            aString = input.nextLine();
        }
        return aString;
    }
}

