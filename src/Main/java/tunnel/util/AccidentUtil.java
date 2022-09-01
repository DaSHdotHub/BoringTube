package Main.java.tunnel.util;


public class AccidentUtil {
    public static int getUserInputByPosition(int lengthOfTunnel) {
        while (true) {
            System.out.println("Unfall an Stelle:");

            int accident = InputUtil.promptInt();

            if (accident <= 0 || accident > lengthOfTunnel) {
                System.out.println("Unfall ausserhalb des Tunnels, weiterer Unfall?");
            } else {
                return accident;
            }
        }
    }

    public static int getNumberOfAccidents() {
        System.out.println("Wie viele Unfaelle?:");
        return InputUtil.promptInt();
    }
}
