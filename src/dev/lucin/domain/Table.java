package dev.lucin.domain;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
        Card card = player.playCard(cardIndex);

        if (!isValidCard(card)) {
            System.err.println("Invalid Card!");
            return;
        }

        List<Card> newPlayerHand = player.hand();
        newPlayerHand.remove(cardIndex);
        player.setHand(newPlayerHand);

        discardPile.addFirst(card);
        currentColor = card.color();
        System.out.println("Played Card: " + card);
    }

    private boolean isValidCard(Card card) {
        if (discardPile.isEmpty()) {
            return true;
        }

        Card topItem = discardPile.peekFirst();
        if (topItem != null) {
            return card.value().equals(topItem.value())
                    || card.color().equals(currentColor);
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
