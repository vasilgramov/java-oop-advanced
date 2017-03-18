package p10_mood3.models;

import p10_mood3.interfaces.Character;

public abstract class BaseCharacter implements Character {
    private String username;
    private String hashedPassword;
    private String characterType;
    private int level;

    protected BaseCharacter(String username, String characterType, int level) {
        this.setUsername(username);
        this.setCharacterType(characterType);
        this.setLevel(level);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getCharacterType() {
        return this.characterType;
    }

    private void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    @Override
    public String getHashedPassword() {
        return this.hashedPassword;
    }

    protected void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    protected abstract void createHashedPassword();

    @Override
    public int getLevel() {
        return this.level;
    }

    private void setLevel(int level) {
        this.level = level;
    }
}
