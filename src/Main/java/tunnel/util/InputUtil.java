package Main.java.tunnel.util;

import java.util.Scanner;

public class InputUtil {
    static Scanner input = new Scanner(System.in);

    public static String promptString() {
        System.out.print(">");
        return input.nextLine();
    }

    public static int promptInt() {
        System.out.print(">");
        return input.nextInt();
    }
}
