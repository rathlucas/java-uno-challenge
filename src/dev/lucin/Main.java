package dev.lucin;

import dev.lucin.domain.Card;
import dev.lucin.domain.Player;
import dev.lucin.domain.Table;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final boolean gameLoop = true;

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

        while (gameLoop) {
            printSeparator();
            System.out.println("Your Hand: " + player1.hand());
            System.out.println("Choose a Card To Play (Enter a Number)");
            System.out.println("Or Enter 0 To See the Discard Pile");

            try {
                int option = sc.nextInt();
                if (option == 0) {
                    System.out.println(table);
                } else {
                    table.makePlay(player1, option);
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid Option, Try Again!");
                sc.nextLine();
            }
        }
    }

    public static int readLine() {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Invalid Option, Try Again!");
            sc.nextLine();
        }

        return -1;
    }

    public static void printSeparator() {
        System.out.println("_".repeat(20));
    }

}
