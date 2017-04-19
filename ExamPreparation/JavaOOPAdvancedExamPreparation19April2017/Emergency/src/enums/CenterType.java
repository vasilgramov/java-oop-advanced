package enums;

/**
 * Created by vladix on 4/19/17.
 */
public enum CenterType {

    FIRE,
    MEDICAL,
    POLICE;

    @Override
    public String toString() {
        String name = name();
        name = name.charAt(0) + name.substring(1).toLowerCase();

        return name;
    }
}
