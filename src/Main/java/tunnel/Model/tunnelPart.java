package Main.java.tunnel.Model;

import Main.java.tunnel.Interface.Limits;

public class tunnelPart {
    char type;
    String exitTo;

    public tunnelPart(String exitTo) {
        this.exitTo = exitTo;
        if (this.exitTo.equals(Limits.phone)) {
            this.type = Limits.phoneChar;
        } else {
            this.type = Limits.tunnelChar;
        }
    }
    public char getType() {
        return type;
    }
    public String getExitTo() {
        return exitTo;
    }
    public tunnelPart(char type, String exitTo){
        this.type = type;
        this.exitTo = exitTo;

    }
}
