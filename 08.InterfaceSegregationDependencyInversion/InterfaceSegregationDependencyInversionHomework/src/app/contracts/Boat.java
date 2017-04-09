package app.contracts;

public interface Boat extends Modelable {

    int getWeight();

    int getSped();

    boolean hasMotor();

    void calcSpeed(Race race);
}
