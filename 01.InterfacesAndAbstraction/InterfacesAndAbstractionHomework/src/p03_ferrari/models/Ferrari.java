package p03_ferrari.models;

import p03_ferrari.interfaces.Car;

public class Ferrari implements Car {
    private static String FERRARI_MODEL = "488-Spider";

    private String driver;

    public Ferrari(String driver) {
        this.setDriver(driver);
    }

    public String getDriver() {
        return this.driver;
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public String gas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", FERRARI_MODEL, this.brakes(), this.gas(), this.getDriver());
    }
}
