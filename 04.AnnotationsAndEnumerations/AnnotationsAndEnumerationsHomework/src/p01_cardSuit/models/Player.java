package p01_cardSuit.models;

import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player> {
    private String name;
    private List<Card> cards;
    private Card highestCard;

    public Player(String name) {
        this.cards = new ArrayList<>();
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Card getHighestCard() {
        return this.highestCard;
    }

    public void setHighestCard(Card highestCard) {
        this.highestCard = highestCard;
    }

    public int getCardsCount() {
        return this.cards.size();
    }

    public void addCard(Card card) {
        this.cards.add(card);

        if (this.getHighestCard() == null || card.getPower() > this.getHighestCard().getPower()) {
            this.setHighestCard(card);
        }
    }

    @Override
    public int compareTo(Player other) {
        return this.getHighestCard().getPower() - other.getHighestCard().getPower();
    }

    @Override
    public String toString() {
        return String.format("%s wins with %s.", this.getName(), this.getHighestCard());
    }
}
