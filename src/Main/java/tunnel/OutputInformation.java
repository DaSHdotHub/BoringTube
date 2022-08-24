package Main.java.tunnel;

import java.util.ArrayList;

public class OutputInformation implements OutputLimit,InputLimits{
    //TODO Actually write Data to ArrayList
    public static ArrayList<tunnelPart> placeExitRole(char[] tunnelParts){
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
            if (tunnelParts[position] == InputLimits.tunnelChar) {
                while (!foundExit) {
                    if (tunnelParts[position + counterToMallorca] != InputLimits.phoneChar && position + counterToMallorca > 0 && position + counterToMallorca< tunnelParts.length) {
                        counterToMallorca++;
                        if (tunnelParts[position + counterToMallorca] == InputLimits.phoneChar) {
                            phonePositionDirectionMallorca = position + counterToMallorca;
                        }
                        else if (position + counterToMallorca == tunnelParts.length) {
                            noPhoneDirectionMallorca = true;

                        }
                    }
                    if (tunnelParts[position + counterToBarcelona] != InputLimits.phoneChar && position + counterToBarcelona > 0 && position + counterToBarcelona< tunnelParts.length) {
                        counterToBarcelona--;
                        if (tunnelParts[position + counterToBarcelona] == InputLimits.phoneChar) {
                            phonePositionDirectionBarcelona = position + counterToMallorca;
                        }
                        else if (position + counterToMallorca == 0) {
                            noPhoneDirectionBarcelona = true;
                        }
                    }
                }
                if (noPhoneDirectionBarcelona && noPhoneDirectionMallorca && position < (tunnelParts.length)/2 ) {
                    exitDirection = OutputLimit.barcelona;
                } else if (noPhoneDirectionBarcelona && noPhoneDirectionMallorca && position >= (tunnelParts.length)/2) {
                    exitDirection = OutputLimit.mallorca;
                } else if (noPhoneDirectionBarcelona && phonePositionDirectionMallorca >= 0) {
                    exitDirection = OutputLimit.phone;
                } else if (noPhoneDirectionMallorca && phonePositionDirectionBarcelona >= 0) {
                    exitDirection = OutputLimit.phone;
                } else if (phonePositionDirectionBarcelona >= 0 && phonePositionDirectionMallorca >= 0) {
                    if (phonePositionDirectionMallorca - position <= position - phonePositionDirectionBarcelona) {
                        exitDirection = OutputLimit.phone;
                    } else if (phonePositionDirectionMallorca - position > position - phonePositionDirectionBarcelona) {
                        exitDirection = OutputLimit.phone;
                    }
                }
            }else {
                exitDirection = OutputLimit.phone;
            }
        }
        return tunnelPartArrayList;
    }
}
