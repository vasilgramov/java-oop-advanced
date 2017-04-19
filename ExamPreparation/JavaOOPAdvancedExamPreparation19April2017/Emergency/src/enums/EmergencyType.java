package enums;

/**
 * Created by vladix on 4/19/17.
 */
public enum EmergencyType {

    PROPERTY,
    HEALTH,
    ORDER;

    @Override
    public String toString() {
        String name = name();
        name = name.charAt(0) + name.toLowerCase().substring(1);

        return name;
    }
}
