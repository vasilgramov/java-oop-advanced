package p10_mood3.models;

public class Demon extends BaseCharacter {
    private static final String DEMON = "Demon";

    private double specialPoints;

    public Demon(String username, double specialPoints, int level) {
        super(username, DEMON, level);
        this.createHashedPassword();
        this.setSpecialPoints(specialPoints);
    }

    public double getSpecialPoints() {
        return this.specialPoints;
    }

    private void setSpecialPoints(double specialPoints) {
        this.specialPoints = specialPoints;
    }

    @Override
    protected void createHashedPassword() {
        super.setHashedPassword((super.getUsername().length() * 217) + "");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("\"%s\" | \"%s\" -> %s%n", super.getUsername(), super.getHashedPassword(), super.getCharacterType()))
                .append(this.getSpecialPoints() * super.getLevel());


        return builder.toString();
    }
}
