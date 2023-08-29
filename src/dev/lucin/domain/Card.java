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

    public static List<Card> getFullDeck() {
        List<Card> deck = new ArrayList<>();

        CardType[] coloredTypes = Arrays.copyOfRange(CardType.values(), 0, 3);
        Color[] numericCardColors = Arrays.copyOfRange(Color.values(), 0, 4);
        for (Color color : numericCardColors) {
            for (int i = 0; i < 10; i++) {
                deck.add(new Card(String.valueOf(i), color));
            }

            for (CardType type : coloredTypes) {
                deck.add(new SpecialCard(type.toString(), color));
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
