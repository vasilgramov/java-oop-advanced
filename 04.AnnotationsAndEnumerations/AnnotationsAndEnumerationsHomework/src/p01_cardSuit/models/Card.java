package p01_cardSuit.models;

import p01_cardSuit.enums.CardRank;
import p01_cardSuit.enums.CardSuit;

public class Card implements Comparable<Card> {
    private CardRank cardRank;
    private CardSuit cardSuit;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.setCardRank(cardRank);
        this.setCardSuit(cardSuit);
    }

    public CardRank getCardRank() {
        return this.cardRank;
    }

    private void setCardRank(CardRank cardRank) {
        this.cardRank = cardRank;
    }

    public CardSuit getCardSuit() {
        return this.cardSuit;
    }

    private void setCardSuit(CardSuit cardSuit) {
        this.cardSuit = cardSuit;
    }

    public int getPower() {
        return this.getCardRank().getPower() + this.cardSuit.getPower();
    }


    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getPower(), o.getPower());
    }

    @Override
    public boolean equals(Object obj) {
        Card card = (Card) obj;

        return this.getCardSuit().equals(card.getCardSuit()) && this.getCardRank().equals(card.getCardRank());
    }

    @Override
    public int hashCode() {
        return (this.getCardSuit() + "" + this.getCardRank()).hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.getCardRank(), this.getCardSuit());
    }
}
