package dev.lucin.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

    public List<Card> hand() {
        return hand;
    }

    protected void setHand(List<Card> newHand) {
        hand = newHand;
    }

    protected Card playCard(int cardIndex) {
        return hand.get(cardIndex);
    }

    protected void drawCard(Card card) {
        hand.add(card);
    }

    protected void drawCard(List<Card> cards) {
        hand.addAll(cards);
    }
}
