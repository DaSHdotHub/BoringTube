package Main.java;
import Main.java.tunnel.ReadInString;
import Main.java.tunnel.ReadInCharArray;
import Main.java.tunnel.tunnelPart;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        OutputInfo();
        char[] tunnelParts = ReadInCharArray.checkUserInput();
        //Analyze Array
        /*  First condition: If nearer to exit as to phone, choose phone.
            Second condition: If two phone in equal distance, choose phone which is nearer to exit.
            Third condition: If second condition cannot be made, choose 'Mallorca'
            Output: "Barcelona", "Telefon", "Mallorca"
            */

        //Process user input
        boolean aFourthCondition = true;
        do {
            int accident;
            System.out.println("Unfall an Stelle:");
            try{
                accident = Integer.parseInt(ReadInString.returnUserInput());
            }
            catch (Exception e) {
                System.out.println("You did not enter a number\nPlease try again:\n");
                accident = Integer.parseInt(ReadInString.returnUserInput());
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
}

