package p10_mood3.models;

public class Archangel extends BaseCharacter {
    private static final String ARCHANGEL = "Archangel";

    private int mana;

    public Archangel(String username, int mana, int level) {
        super(username, ARCHANGEL, level);
        this.createHashedPassword();
        this.setMana(mana);
    }

    public int getMana() {
        return this.mana;
    }

    private void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    protected void createHashedPassword() {
        super.setHashedPassword(new StringBuilder(super.getUsername()).reverse() + ((super.getUsername().length()) * 21 + ""));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("\"%s\" | \"%s\" -> %s%n", super.getUsername(), super.getHashedPassword(), super.getCharacterType()))
                .append(this.getMana() * super.getLevel());


        return builder.toString();
    }
}
