package Main.java;
import Main.java.tunnel.util.AccidentUtil;
import Main.java.tunnel.util.ExitParamsUtil;
import Main.java.tunnel.model.TunnelPart;

import java.util.Arrays;
import java.util.List;

import Main.java.tunnel.util.CharArrayUtil;

public class Main {

    private static final String INFO_MESSAGE = "Type in a value for each part of the tunnel (max. 500000), parts with 'X' anzeigt, dass es in diesem Abschnitt ein Telefon gibt, und '-',\n" +
            " dass es kein Telefon gibt. Das erste Zeichen steht für den Abschnitt Barcelona (Pos = 0).";

    public static void main(String[] args) {

        System.out.println(INFO_MESSAGE);

        char[] tunnelParts = CharArrayUtil.readTunnelParts();

        //Process user input accidents
        int numberOfAccidents = AccidentUtil.getNumberOfAccidents();
        int[] accidents = new int[numberOfAccidents];

        for (int i = 0; i < numberOfAccidents; i++) {
            accidents[i] = AccidentUtil.getUserInputByPosition(tunnelParts.length) - 1;
        }

        List <TunnelPart> tunnel = ExitParamsUtil.getPlaceExitRole(tunnelParts);

        //Print Output
        Arrays.stream(accidents)
                .mapToObj(accident -> tunnel.get(accident).getExitTo())
                .forEach(System.out::println);
    }

}
