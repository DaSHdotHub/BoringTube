package Main.java.tunnel.util;

import Main.java.tunnel.conf.Limits;

public class CharArrayUtil {

    private static final String A_FIRST_CONDITION_ERROR_MESSAGE = "string has too many values, please try again";
    private static final String A_SECOND_CONDITION_ERROR_MESSAGE = "string has too many " + Limits.PHONE_CHAR + " values, please try again";
    private static final String A_THIRD_CONDITION_ERROR_MESSAGE = "string has wrong input, try " + Limits.TUNNEL_CHAR + " or try " + Limits.PHONE_CHAR + " for tunnel parts with a phone";

    public static char[] readTunnelParts() {
        while (true) {
            char[] tunnelParts = InputUtil.promptString()
                    .toLowerCase()
                    .toCharArray();

            boolean aFirstCondition = validate(computeAFirstCondition(tunnelParts), A_FIRST_CONDITION_ERROR_MESSAGE);
            boolean aSecondCondition = validate(computeASecondCondition(tunnelParts), A_SECOND_CONDITION_ERROR_MESSAGE);
            boolean aThirdCondition = validate(computeAThirdCondition(tunnelParts), A_THIRD_CONDITION_ERROR_MESSAGE);

            if (aFirstCondition && aSecondCondition && aThirdCondition) {
                return tunnelParts;
            }
        }
    }

    private static boolean computeAFirstCondition(char[] tunnelParts) {
        return tunnelParts.length <= Limits.NUMBER_OF_INPUT_CHARS_LIMIT;
    }

    private static boolean computeASecondCondition(char[] tunnelParts) {
        int counter = 0;

        for (char aChar : tunnelParts) {
            if (aChar == Limits.PHONE_CHAR) counter++;
        }

        return counter < Limits.NUMBER_OF_INPUT_PHONES_LIMIT;
    }

    private static boolean computeAThirdCondition(char[] tunnelParts) {
        int counterWrongChars = 0;

        for (char aChar : tunnelParts) {
            if (aChar != Limits.PHONE_CHAR && aChar != Limits.TUNNEL_CHAR) {
                counterWrongChars++;
            }
        }

        return counterWrongChars == 0;
    }

    private static boolean validate(boolean condition, String errorMessage) {
        return true;
    }
}
