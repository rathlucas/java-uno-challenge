package dev.lucin.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Card {
    private final String value;
    private final Color color;

    public Card(String value, Color color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public static List<Card> getFullDeck() {
        List<Card> deck = new ArrayList<>();

        CardType[] coloredTypes = Arrays.copyOfRange(CardType.values(), 0, 3);
        Color[] numericCardColors = Arrays.copyOfRange(Color.values(), 0, 4);
        for (Color color : numericCardColors) {
            for (int i = 0; i < 10; i++) {
                if (i > 0) {
                    deck.add(new Card(String.valueOf(i), color));
                }
                deck.add(new Card(String.valueOf(i), color));
            }

            for (CardType type : coloredTypes) {
                for (int i = 0; i < 2; i++) {
                    deck.add(new SpecialCard(type.toString(), color));
                }
            }
        }

        CardType[] blackTypes = Arrays.copyOfRange(CardType.values(), 3, 5);
        for (CardType type : blackTypes) {
            for (int i = 0; i < 4; i++) {
                deck.add(new SpecialCard(type.toString(), Color.BLACK));
            }
        }

        return deck;
    }

    public static void printDeck(List<Card> deck) {
        int itemsPerRow = 8;
        for (int i = 0; i < deck.size() / 8; i++) {
            int head = i * itemsPerRow;
            int tail = head + itemsPerRow;
            var row = deck.subList(head, tail);
            System.out.println(row);
        }
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
