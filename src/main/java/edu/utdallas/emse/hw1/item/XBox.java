package edu.utdallas.emse.hw1.item;

public class XBox implements Item {
    public enum Type {
        XBOX_ORIGINAL, XBOX_360, XBOX_ONE
    }

    private final Type console;

    public XBox(Type console) {
        this.console = console;
    }

    public Type getConsole() {
        return console;
    }

    @Override
    public String toString() {
        return "Xbox " + getConsole().toString();
    }
}
