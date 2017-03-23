package p03_coffeeMachine.enums;

public enum Coin {
    ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50);

    private int value;

    Coin(int value) {
        this.setValue(value);
    }

    public int getValue() {
        return this.value;
    }

    private void setValue(int value) {
        this.value = value;
    }
}
