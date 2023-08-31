package dev.lucin.domain;

import java.util.*;

public class Table {
    private Color currentColor;
    private final Deque<Card> discardPile = new ArrayDeque<>();

    public Table() {
    }

    public void addCard(Card card) {
        if (!isValidCard(card)) {
            System.err.println("Invalid Card!");
            return;
        }

        discardPile.addFirst(card);
        currentColor = card.getColor();
        System.out.println("Played Card: " + card);
    }

    private boolean isValidCard(Card card) {
        if (discardPile.isEmpty()) {
            return true;
        }

        Card topItem = discardPile.peekFirst();
        if (topItem != null) {
            return card.getValue().equals(topItem.getValue())
                    || card.getColor().equals(currentColor);
        }

        return false;
    }

    @Override
    public String toString() {
        return """
                Current Color: (%s)
                Last Played Card: (%s)%n""".formatted(currentColor, discardPile.peekFirst());
    }
}
