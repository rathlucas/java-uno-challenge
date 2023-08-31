package dev.lucin;

import dev.lucin.domain.Card;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        var deck = Card.getFullDeck();
        Card.printDeck(deck);
        Collections.shuffle(deck);
    }
}
