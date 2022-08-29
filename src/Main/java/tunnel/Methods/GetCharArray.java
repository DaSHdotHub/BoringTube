package Main.java.tunnel.Methods;

import Main.java.tunnel.Interface.Limits;

public class GetCharArray implements Limits {
    public static char[] checkUserInput() {
        boolean aFirstCondition = false;
        boolean aSecondCondition = false;
        boolean aThirdCondition = false;
        boolean doNotExitLoop = true;
        char[] tunnelParts;
        do {
            tunnelParts = GetInput.UserInputString().toLowerCase().toCharArray();

            if (tunnelParts.length <= Limits.numberOfInputCharsLimit) {
                aFirstCondition = true;
            } else {
                System.out.println("string has too many values, please try again");
            }

            int counter = 0;
            for (char aChar : tunnelParts) {
                if (aChar == Limits.phoneChar) counter++;
            }
            if (counter < Limits.numberOfInputPhonesLimit) {
                aSecondCondition = true;
            } else {
                System.out.println("string has too many " + Limits.phoneChar + " values, please try again");
            }
            int counterWrongChars = 0;
            for (char aChar : tunnelParts) {
                if (aChar != Limits.phoneChar && aChar != Limits.tunnelChar) {
                    counterWrongChars++;
                }
            }
            if (counterWrongChars != 0) {
                System.out.println("string has wrong input, try " + Limits.tunnelChar + " or try " + Limits.phoneChar + " for tunnelparts with a phone:");
            } else {
                aThirdCondition = true;
            }
            if (aFirstCondition && aSecondCondition && aThirdCondition){
                doNotExitLoop = false;
            }
        } while (doNotExitLoop);
        return tunnelParts;
    }
}
