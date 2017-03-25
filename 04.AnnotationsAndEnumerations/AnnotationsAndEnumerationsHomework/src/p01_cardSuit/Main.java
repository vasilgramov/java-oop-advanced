package p01_cardSuit;

import p01_cardSuit.enums.CardRank;
import p01_cardSuit.enums.CardSuit;
import p01_cardSuit.models.Card;
import p01_cardSuit.models.Deck;
import p01_cardSuit.models.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Deck deck = new Deck();
        deck.generateDeck();

        Player firstPlayer = new Player(in.nextLine());
        Player secondPlayer = new Player(in.nextLine());

        getPlayerCards(in, deck, firstPlayer);
        getPlayerCards(in, deck, secondPlayer);

        if (firstPlayer.compareTo(secondPlayer) > 0) {
            System.out.println(firstPlayer);
        } else {
            System.out.println(secondPlayer);
        }
    }

    private static void getPlayerCards(Scanner in, Deck deck, Player player) {
        while (player.getCardsCount() < 5) {
            String[] cardArgs = in.nextLine().split(" of ");
            try {
                CardRank cardRank = CardRank.valueOf(cardArgs[0]);
                CardSuit cardSuit = CardSuit.valueOf(cardArgs[1]);

                Card card = new Card(cardRank, cardSuit);
                try {
                    deck.removeCard(card);
                    player.addCard(card);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } catch (IllegalArgumentException e) {
                System.out.println("No such card exists.");
            }
        }
    }
}
