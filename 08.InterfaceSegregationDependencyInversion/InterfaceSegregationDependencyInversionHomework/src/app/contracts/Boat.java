package app.contracts;

public interface Boat extends Modelable {

    int getWeight();

    double getSped();

    boolean hasMotor();

    void calcSpeed(Race race);
}
