package Main.java;
import Main.java.tunnel.Methods.GetAccident;
import Main.java.tunnel.Methods.SetExitParams;
import Main.java.tunnel.Model.tunnelPart;

import java.util.Arrays;
import java.util.List;

import static Main.java.tunnel.Methods.GetCharArray.*;


public class Main {
    public static void main(String[] args) {

        OutputInfo();
        char[] tunnelParts = checkUserInput();
        //Analyze Array
        /*  First condition: If nearer to exit as to phone, choose phone.
            Second condition: If two phone in equal distance, choose phone which is nearer to exit.
            Third condition: If second condition cannot be made, choose 'Mallorca'
            Output: "Barcelona", "Telefon", "Mallorca"
            */
        List <tunnelPart> tunnel = SetExitParams.placeExitRole(tunnelParts);

        //Process user input accidents
        int numberOfAccidents = GetAccident.NumberOfAccidents();
        int[] accidents = new int[numberOfAccidents];
        for (int i = 0; i < numberOfAccidents; i++) {
            accidents[i] = GetAccident.UserInputByPosition(tunnelParts.length) - 1;
        }
        //Print Output
        Arrays.stream(accidents).mapToObj(accident -> tunnel.get(accident).getExitTo()).forEach(System.out::println);
    }

    public static void OutputInfo() {
        System.out.println("Type in a value for each part of the tunnel (max. 500000), parts with 'X' anzeigt, dass es in diesem Abschnitt ein Telefon gibt, und '-',\n" +
                " dass es kein Telefon gibt. Das erste Zeichen steht für den Abschnitt Barcelona (Pos = 0).");
    }
}

