package models.emergencies;

public abstract class BaseServiceCenter implements Center {

    private String name;

    private Integer amountOfMaximumEmergencies;

    private Integer emergenciesCount;

    protected BaseServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);

        this.emergenciesCount = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getAmountOfMaximumEmergencies() {
        return amountOfMaximumEmergencies;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }

    @Override
    public Boolean isForRetirement() {
        return this.emergenciesCount >= amountOfMaximumEmergencies;
    }

    @Override
    public void processEmergency() {
        this.emergenciesCount++;
    }
}
