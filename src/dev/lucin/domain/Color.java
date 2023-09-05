package dev.lucin.domain;

public enum Color {
    RED, GREEN, BLUE, YELLOW, BLACK;

    static Color getColor(int value) {
        return switch (value) {
            case 1 -> RED;
            case 2 -> GREEN;
            case 3 -> BLUE;
            case 4 -> YELLOW;
            case 5 -> BLACK;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }
}
