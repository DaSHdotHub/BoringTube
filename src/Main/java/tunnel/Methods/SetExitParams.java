package Main.java.tunnel.Methods;
import Main.java.tunnel.Interface.Limits;
import Main.java.tunnel.Model.tunnelPart;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public class SetExitParams implements Limits {
    public static List<tunnelPart> placeExitRole(char[] tunnelParts){

        return mapExitToList(mapCharArrayToList(tunnelParts));
    }

    private static List<tunnelPart> mapCharArrayToList(char[] aCharArray) {
        List<tunnelPart> aList = new ArrayList<>();
        for (int counter = 0; counter < aCharArray.length; counter++) {
            // Index = 0 is always Barcelona
            // Last index is always Mallorca
            if (counter == 0) {
                aList.add(new tunnelPart(aCharArray[counter], Limits.barcelona));
            } else if (counter == aCharArray.length - 1) {
                aList.add(new tunnelPart(aCharArray[counter], Limits.mallorca));
            }else aList.add(new tunnelPart(aCharArray[counter], null));
        }
        return aList;
    }

    private static List<tunnelPart> mapExitToList(List<tunnelPart> aList) {
        Predicate<tunnelPart> t1 = element -> element.getType() == Limits.phoneChar;
        if (aList.stream().anyMatch(t1)) {
            //Phones in tunnel
            for(int counter = 1; counter < aList.size() - 1; counter++) {
                //Check if there is a middle
                if (counter == (aList.size() - 1) / 2 && aList.size() / 2 != 0) {
                    //Check if two phones are in equal distance from the middle
                    for (int i = 1; i < counter; i++) {
                        if (aList.get(counter + i).getType() == Limits.phoneChar && aList.get(counter - i).getType() == Limits.phoneChar) {
                            aList.set(counter, new tunnelPart(aList.get(counter).getType(),Limits.mallorca));
                        }
                    }
                } else {
                    aList.set(counter, new tunnelPart(aList.get(counter).getType(),Limits.phone));
                }
            }

        } else {
            //No phones in tunnel
            for(int counter = 1; counter < aList.size() -1; counter++) {
                if (counter < aList.size() / 2) {
                    aList.set(counter, new tunnelPart(aList.get(counter).getType(),Limits.barcelona));
                } else {
                    aList.set(counter, new tunnelPart(aList.get(counter).getType(),Limits.mallorca));
                }

            }
        }
        return aList;
    }
}
