package Main.java.tunnel.Methods;
import Main.java.tunnel.Interface.Limits;
import Main.java.tunnel.Model.tunnelPart;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
public class SetExitParams implements Limits {
    public static List<tunnelPart> placeExitRole(char[] tunnelParts){
        List<tunnelPart> tunnelPartsList = new ArrayList<>();

        for (int counter = 0; counter < tunnelParts.length; counter++) {
            // Index = 0 is always Barcelona
            // Last index is always Mallorca
            if (counter == 0) {
                tunnelPartsList.add(new tunnelPart(tunnelParts[counter], Limits.barcelona));
            } else if (counter == tunnelParts.length - 1) {
                tunnelPartsList.add(new tunnelPart(tunnelParts[counter], Limits.mallorca));
            }else tunnelPartsList.add(new tunnelPart(tunnelParts[counter], null));
        }


        Predicate<tunnelPart> t1 = element -> element.getType() == Limits.phoneChar;
        if (tunnelPartsList.stream().anyMatch(t1)) {
            //Phones in tunnel
            for(int counter = 1; counter < tunnelPartsList.size() - 1; counter++) {
                //Check if there is a middle
                if (counter == (tunnelPartsList.size() - 1) / 2 && tunnelPartsList.size() / 2 != 0) {
                    //Check if two phones are in equal distance from the middle
                    for (int i = 1; i < counter; i++) {
                        if (tunnelPartsList.get(counter + i).getType() == Limits.phoneChar && tunnelPartsList.get(counter - i).getType() == Limits.phoneChar) {
                            tunnelPartsList.set(counter, new tunnelPart(tunnelPartsList.get(counter).getType(),Limits.mallorca));
                        }
                    }
                } else {
                    tunnelPartsList.set(counter, new tunnelPart(tunnelPartsList.get(counter).getType(),Limits.phone));
                }
            }

        } else {
            //No phones in tunnel
            for(int counter = 1; counter < tunnelPartsList.size() -1; counter++) {
                if (counter < tunnelPartsList.size() / 2) {
                    tunnelPartsList.set(counter, new tunnelPart(tunnelPartsList.get(counter).getType(),Limits.barcelona));
                } else {
                    tunnelPartsList.set(counter, new tunnelPart(tunnelPartsList.get(counter).getType(),Limits.mallorca));
                }

            }
        }
        return tunnelPartsList;
    }
}
