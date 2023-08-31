package dev.lucin;

import dev.lucin.domain.Card;
import dev.lucin.domain.Player;
import dev.lucin.domain.Table;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static Table table = new Table();
    private static Scanner sc = new Scanner(System.in);
    private static boolean gameLoop = true;

    public static void main(String[] args) {
        var deck = Card.getFullDeck();
        Collections.shuffle(deck);

        Player player1 = new Player();
        Player player2 = new Player();

        Card.dealHand(deck, player1);
        Card.dealHand(deck, player2);

        while (gameLoop) {
            System.out.println("Your Hand: " + player1.getHand());

        }
    }
}
