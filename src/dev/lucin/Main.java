package dev.lucin;

import dev.lucin.domain.Card;
import dev.lucin.domain.Color;

public class Main {
    private static Color tableColor;

    public static void main(String[] args) {
        var deck = Card.getFullDeck();
        System.out.println("Uno Deck = " + deck);
    }
}
