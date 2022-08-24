package Main.java.tunnel;

public class ReadInCharArray implements InputLimits{
    //Analyze Input
        /*  First condition: number of signs <= 50000
            Second condition: number of phone <= 1000
            Third condition: input parameter 'x' and '-'
            */
    public static char[] checkUserInput() {
        boolean aFirstCondition = false;
        boolean aSecondCondition = false;
        boolean aThirdCondition = false;
        boolean doNotExitLoop = true;
        char[] tunnelParts;
        do {
            tunnelParts = ReadInString.returnUserInput().toCharArray();

            if (tunnelParts.length <= InputLimits.numberOfInputCharsLimit) {
                aFirstCondition = true;
            } else {
                System.out.println("string has too many values, please try again");
            }

            int counter = 0;
            for (char aChar : tunnelParts) {
                if (aChar == InputLimits.phoneChar) counter++;
            }
            if (counter < InputLimits.numberOfInputPhonesLimit) {
                aSecondCondition = true;
            } else {
                System.out.println("string has too many " + InputLimits.phoneChar + " values, please try again");
            }
            int counterWrongChars = 0;
            for (char aChar : tunnelParts) {
                if (aChar != InputLimits.phoneChar && aChar != InputLimits.tunnelChar) {
                    counterWrongChars++;
                }
            }
            if (counterWrongChars != 0) {
                System.out.println("string has wrong input, try " + InputLimits.tunnelChar + " or try " + InputLimits.phoneChar + " for tunnelparts with a phone:");
            } else {
                aThirdCondition = true;
            }
            if (aFirstCondition && aSecondCondition && aThirdCondition){
                doNotExitLoop = !true;
            }
        } while (doNotExitLoop);
        return tunnelParts;
    }
}
