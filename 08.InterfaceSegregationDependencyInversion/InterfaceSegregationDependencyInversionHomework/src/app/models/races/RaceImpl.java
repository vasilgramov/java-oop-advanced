package app.models.races;

import app.contracts.Boat;
import app.contracts.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceImpl implements Race {
    private int distnace;
    private int windSpeed;
    private int oceanSpee;
    private boolean allowsMotorboats;
    private List<Boat> participants;

    public RaceImpl(int distance, int windSpeed, int oceanSpeed, boolean allowsMotorboats) {
        this.distnace = distance;
        this.windSpeed = windSpeed;
        this.oceanSpee = oceanSpeed;
        this.allowsMotorboats = allowsMotorboats;

        this.participants = new ArrayList<>();
    }

    @Override
    public int getDistance() {
        return this.distnace;
    }

    @Override
    public int getWindSpeed() {
        return this.windSpeed;
    }

    @Override
    public int getOceanSpeed() {
        return this.oceanSpee;
    }

    @Override
    public boolean allowsMotorboats() {
        return this.allowsMotorboats;
    }

    @Override
    public List<Boat> getParticipants() {
        return this.participants;
    }

    @Override
    public void addParticipant(Boat boat) {
        this.participants.add(boat);
    }
}
