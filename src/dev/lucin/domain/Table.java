package dev.lucin.domain;


import dev.lucin.Main;

import java.util.*;

public class Table {
    private final List<Player> players;
    private final Deque<Card> discardPile = new ArrayDeque<>();
    private Color currentColor;

    public Table(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public void dealHands(List<Card> deck) {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck.remove(0));
            }
        }
    }

    public void makePlay(Player player, int cardIndex) {
        int realIndex = cardIndex - 1;
        if (realIndex < 0 || realIndex > player.hand().size()) {
            System.err.println("Invalid Card Position!");
            return;
        }

        Card card = player.playCard(cardIndex - 1);
        if (!isValidCard(card)) {
            Main.printSeparator();
            System.err.println("Invalid Card: " + card);
            System.err.println("Top of The Discard Pile: " + discardPile.peekFirst());
            return;
        }

        List<Card> newPlayerHand = player.hand();
        newPlayerHand.remove(cardIndex - 1);
        player.setHand(newPlayerHand);

        discardPile.addFirst(card);
        currentColor = (card.color().equals(Color.BLACK))
                ? chooseColor()
                : card.color();

        System.out.println(this);
    }

    private boolean isValidCard(Card card) {
        if (discardPile.isEmpty()) {
            return true;
        }

        if (card.color().equals(Color.BLACK)) {
            return true;
        }

        Card topItem = discardPile.peekFirst();
        if (topItem != null) {
            return card.value().equals(topItem.value())
                    || card.color().equals(currentColor);
        }

        return false;
    }

    private Color chooseColor() {
        Main.printSeparator();
        System.out.println("Choose a Color: ");

        for (Color color : Color.values()) {
            if (color != Color.BLACK) {
                System.out.print(color + " ");
            }
        }

        int option = Main.readLine();
        return Color.getColor(option);
    }

    @Override
    public String toString() {
        Main.printSeparator();
        return """
                Current Color: (%s)
                Last Played Card: (%s)%n""".formatted(currentColor, discardPile.peekFirst());
    }
}
