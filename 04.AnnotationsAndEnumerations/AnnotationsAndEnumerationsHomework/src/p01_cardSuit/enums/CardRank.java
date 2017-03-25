package p01_cardSuit.enums;

import p01_cardSuit.annotations.EnumAnnotation;

@EnumAnnotation(type = "Enumeration", category = "Rank", description = "Provides rank constants for a Card class.")
public enum CardRank {
    ACE(14), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

    private int power;

    CardRank(int power) {
        this.setPower(power);
    }

    public int getPower() {
        return this.power;
    }

    private void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return super.name();
    }
}
