package p10_infernoInfinity.enums;

public enum WeaponType {
    AXE(5, 10, 4), SWORD(4, 6, 3), KNIFE(3, 4, 2);

    private int minDMG;
    private int maxDMG;
    private int numberOfSockets;

    WeaponType(int minDMG, int maxDMG, int numberOfSockets) {
        this.setMinDMG(minDMG);
        this.setMaxDMG(maxDMG);
        this.setNumberOfSockets(numberOfSockets);
    }

    public int getMinDMG() {
        return this.minDMG;
    }

    private void setMinDMG(int minDMG) {
        this.minDMG = minDMG;
    }

    public int getMaxDMG() {
        return this.maxDMG;
    }

    private void setMaxDMG(int maxDMG) {
        this.maxDMG = maxDMG;
    }

    public int getNumberOfSockets() {
        return this.numberOfSockets;
    }

    private void setNumberOfSockets(int numberOfSockets) {
        this.numberOfSockets = numberOfSockets;
    }
}
