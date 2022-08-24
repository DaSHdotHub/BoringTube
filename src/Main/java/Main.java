package Main.java;
import Main.java.tunnel.tunnelPart;
import java.util.ArrayList;
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
            Output: "Barcelona", "Telefon", "Mallorca"
            */
        ArrayList<tunnelPart> tunnelPartArrayList = new ArrayList<>();
        boolean foundExit = false;
        boolean noPhoneDirectionMallorca = false;
        boolean noPhoneDirectionBarcelona = false;

        int counterToMallorca = 0;
        int counterToBarcelona = 0;
        int phonePositionDirectionMallorca = -1;
        int phonePositionDirectionBarcelona = -1;
        String exitDirection;
        for (int position = 0; position < tunnelParts.length; position++){
            if (tunnelParts[position] == '-') {
                while (!foundExit) {
                    if (tunnelParts[position + counterToMallorca] != 'x' && position + counterToMallorca > 0 && position + counterToMallorca< tunnelParts.length) {
                        counterToMallorca++;
                        if (tunnelParts[position + counterToMallorca] == 'x') {
                            phonePositionDirectionMallorca = position + counterToMallorca;
                        }
                        else if (position + counterToMallorca == tunnelParts.length) {
                            noPhoneDirectionMallorca = true;
                            
                        }
                    }
                    if (tunnelParts[position + counterToBarcelona] != 'x' && position + counterToBarcelona > 0 && position + counterToBarcelona< tunnelParts.length) {
                        counterToBarcelona--;
                        if (tunnelParts[position + counterToBarcelona] == 'x') {
                            phonePositionDirectionBarcelona = position + counterToMallorca;
                        }
                        else if (position + counterToMallorca == 0) {
                            noPhoneDirectionBarcelona = true;
                        }
                    }
                }
                if (noPhoneDirectionBarcelona && noPhoneDirectionMallorca && position < (tunnelParts.length)/2 ) {
                    exitDirection = "Barcelona";
                } else if (noPhoneDirectionBarcelona && noPhoneDirectionMallorca && position >= (tunnelParts.length)/2) {
                    exitDirection = "Mallorca";
                } else if (noPhoneDirectionBarcelona && phonePositionDirectionMallorca >= 0) {
                    exitDirection = "Telefon";
                } else if (noPhoneDirectionMallorca && phonePositionDirectionBarcelona >= 0) {
                    exitDirection = "Telefon";
                } else if (phonePositionDirectionBarcelona >= 0 && phonePositionDirectionMallorca >= 0) {
                    if (phonePositionDirectionMallorca - position <= position - phonePositionDirectionBarcelona) {
                        exitDirection = "Telefon";
                    } else if (phonePositionDirectionMallorca - position > position - phonePositionDirectionBarcelona) {
                        exitDirection = "Telefon";
                    }
                }
            }else {
                exitDirection = "Telefon";
                }
            }


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

