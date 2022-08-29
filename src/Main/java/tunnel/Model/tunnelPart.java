package Main.java.tunnel.Model;

public class tunnelPart {
    char type;
    String exitTo;

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
