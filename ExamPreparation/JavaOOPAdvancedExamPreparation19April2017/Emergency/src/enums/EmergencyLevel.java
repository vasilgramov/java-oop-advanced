package enums;

public enum EmergencyLevel {

    MINOR,
    MAJOR,
    DISASTER;


    @Override
    public String toString() {
        String name = name();
        name = name.charAt(0) + name.toLowerCase().substring(1);
        return name;
    }
}
