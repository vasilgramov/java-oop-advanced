package app.contracts;

import java.util.List;

public interface Race {

    int getDistance();

    int getWindSpeed();

    int getOceanSpeed();

    boolean allowsMotorboats();

    List<Boat> getParticipants();

    void addParticipant(Boat boat);
}
