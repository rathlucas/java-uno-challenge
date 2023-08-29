package dev.lucin.domain;

import java.util.ArrayList;
import java.util.List;

public class Card {
    private final String value;
    private final Color color;

    public Card(String value, Color color) {
        this.value = value;
        this.color = color;
    }

    public static List<Card> getFullDeck() {
        List<CardType> coloredTypes = List.of(CardType.values()).subList(0, 3);

        List<Card> deck = new ArrayList<>();
        for (Color color : Color.values()) {
            for (int i = 0; i < 10; i++) {
                deck.add(new Card(String.valueOf(i), color));
            }

            for (CardType type : coloredTypes) {
                deck.add(new Card(type.toString(), color));
            }
        }

        return deck;
    }

    @Override
    public String toString() {
        return "%s (%s)".formatted(value, color);
    }
}

class SpecialCard extends Card {
    private CardType type;

    public SpecialCard(String value, Color color) {
        super(value, color);
    }
}
