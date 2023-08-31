package dev.lucin;

import dev.lucin.domain.Card;
import dev.lucin.domain.Player;
import dev.lucin.domain.Table;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    private Table table = new Table();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        var deck = Card.getFullDeck();
        Collections.shuffle(deck);

        Player player1 = new Player();
        Player player2 = new Player();

        Card.dealHand(deck, player1);
        Card.dealHand(deck, player2);

        System.out.println("Player 1 Hand: " + player1.getHand());
        System.out.println("Player 2 Hand: " + player2.getHand());
    }
}
