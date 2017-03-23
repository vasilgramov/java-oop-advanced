package p03_coffeeMachine.enums;

public enum  CoffeeSize {
    SMALL(50, 50), NORMAL(100, 75), DOUBLE(200, 100);

    private int dosage;
    private int price;

    CoffeeSize(int dosage, int price) {
        this.setDosage(dosage);
        this.setPrice(price);
    }

    public int getDosage() {
        return this.dosage;
    }

    private void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public int getPrice() {
        return this.price;
    }

    private void setPrice(int price) {
        this.price = price;
    }
}
