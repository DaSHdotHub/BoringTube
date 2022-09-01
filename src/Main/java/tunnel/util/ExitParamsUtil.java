package Main.java.tunnel.util;

import Main.java.tunnel.conf.Limits;
import Main.java.tunnel.model.TunnelPart;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ExitParamsUtil extends Limits {
    public static List<TunnelPart> getPlaceExitRole(char[] tunnelParts) {

        return mapExitToList(mapCharArrayToList(tunnelParts));
    }

    private static List<TunnelPart> mapCharArrayToList(char[] aCharArray) {
        List<TunnelPart> aList = new ArrayList<>();
        for (int counter = 0; counter < aCharArray.length; counter++) {
            // Index = 0 is always Barcelona
            // Last index is always Mallorca
            if (counter == 0) {
                aList.add(new TunnelPart(aCharArray[counter], Limits.BARCELONA));
            } else if (counter == aCharArray.length - 1) {
                aList.add(new TunnelPart(aCharArray[counter], Limits.MALLORCA));
            } else aList.add(new TunnelPart(aCharArray[counter], null));
        }
        return aList;
    }

    private static List<TunnelPart> mapExitToList(List<TunnelPart> aList) {
        Predicate<TunnelPart> t1 = element -> element.getType() == Limits.PHONE_CHAR;
        if (aList.stream().anyMatch(t1)) {
            //Phones in tunnel
            for (int counter = 1; counter < aList.size() - 1; counter++) {
                //Check if there is a middle
                if (counter == (aList.size() - 1) / 2 && aList.size() / 2 != 0) {
                    //Check if two phones are in equal distance from the middle
                    for (int i = 1; i < counter; i++) {
                        if (aList.get(counter + i).getType() == Limits.PHONE_CHAR && aList.get(counter - i).getType() == Limits.PHONE_CHAR) {
                            aList.set(counter, new TunnelPart(aList.get(counter).getType(), Limits.MALLORCA));
                        }
                    }
                } else {
                    aList.set(counter, new TunnelPart(aList.get(counter).getType(), Limits.PHONE));
                }
            }

        } else {
            //No phones in tunnel
            for (int counter = 1; counter < aList.size() - 1; counter++) {
                if (counter < aList.size() / 2) {
                    aList.set(counter, new TunnelPart(aList.get(counter).getType(), Limits.BARCELONA));
                } else {
                    aList.set(counter, new TunnelPart(aList.get(counter).getType(), Limits.MALLORCA));
                }

            }
        }
        return aList;
    }
}
