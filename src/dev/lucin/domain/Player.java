package dev.lucin.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand = new ArrayList<>();

    public List<Card> getHand() {
        return hand;
    }

    public Card playCard(Card card) {
        int cardIndex = hand.indexOf(card);
        return hand.get(cardIndex);
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public void drawCard(List<Card> cards) {
        hand.addAll(cards);
    }
}
