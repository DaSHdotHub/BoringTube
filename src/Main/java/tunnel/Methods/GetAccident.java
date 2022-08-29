package Main.java.tunnel.Methods;


public class GetAccident {
    public static int UserInputByPosition(int lengthOfTunnel) {
        boolean aCondition = true;
        int accident;
        do {
            System.out.println("Unfall an Stelle:");
            accident = GetInput.UserInputInt();
            if (accident < 0 || accident > lengthOfTunnel) {
                System.out.println("Unfall ausserhalb des Tunnels, weiterer Unfall?");
            } else {
                aCondition = false;
            }
        }
        while (aCondition);
        return accident;
    }
    public static int NumberOfAccidents() {
        System.out.println("Wie viele Unfaelle?:");
        return GetInput.UserInputInt();
    }
}
