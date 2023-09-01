package dev.lucin;

import dev.lucin.domain.Card;
import dev.lucin.domain.Player;
import dev.lucin.domain.Table;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static boolean gameLoop = true;

    public static void main(String[] args) {
        var deck = Card.getFullDeck();
        Collections.shuffle(deck);

        Player player1 = new Player("Lucin");
        Player player2 = new Player("Flavin");

        Table table = new Table(List.of(player1, player2));
        table.dealHands(deck);

        System.out.printf("""
                Players:
                %s
                %s%n""", player1.name(), player2.name());

        System.out.println("_".repeat(20));

        while (gameLoop) {
            System.out.println("Your Hand: " + player1.hand());
            System.out.println("Choose a Card To Play (Enter a Number)");

            try {
                int option = sc.nextInt();
                System.out.println("Chosen Option: " + option);
                gameLoop = false;
            } catch (InputMismatchException e) {
                System.err.println("Invalid Option, Try Again!");
                sc.nextLine();
            }
        }
    }
}
