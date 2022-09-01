package Main.java.tunnel.model;

public class TunnelPart {
    private final char type;
    private final String exitTo;

    public TunnelPart(char type, String exitTo) {
        this.type = type;
        this.exitTo = exitTo;
    }

    public char getType() {
        return type;
    }

    public String getExitTo() {
        return exitTo;
    }
}
