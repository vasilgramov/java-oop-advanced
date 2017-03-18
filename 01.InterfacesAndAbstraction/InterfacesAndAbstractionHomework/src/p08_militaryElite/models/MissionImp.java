package p08_militaryElite.models;

import p08_militaryElite.interfaces.Mission;

public class MissionImp implements Mission {
    private String codeName;
    private String state;

    public MissionImp(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    private void setState(String state) {
            if (state.equals("inProgress") || state.equals("Finished")) {
            this.state = state;
        }
    }

    @Override
    public void completeMission() {
        this.setState("Finished");
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}
