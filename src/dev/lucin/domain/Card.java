package dev.lucin.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Card(String value, Color color) {
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
                    deck.add(new Card(type.toString(), color));
                }
            }
        }

        CardType[] blackTypes = Arrays.copyOfRange(CardType.values(), 3, 5);
        for (CardType type : blackTypes) {
            System.out.println(type);
            for (int i = 0; i < 4; i++) {
                deck.add(new Card(type.name(), Color.BLACK));
            }
        }

        return deck;
    }

    public static void printDeck(List<Card> deck) {
        int itemsPerRow = 8;
        for (int i = 0; i < deck.size() / 8; i++) {
            int head = i * itemsPerRow;
            int tail = head + itemsPerRow + 4;
            var row = deck.subList(head, tail);
            System.out.println(row);
        }
    }

    @Override
    public String toString() {
        return "%s (%s)".formatted(value, color);
    }
}
