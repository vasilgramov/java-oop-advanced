package app.utility;

public class Validator {
    public static void validatePropertyValue(int value, String propertyName) {
        if (value <= 0) {
            throw new IllegalArgumentException(String.format(Constants.IncorrectPropertyValueMessage, propertyName));
        }
    }

    public static void validateModelLength(String value, int minModelLength) {
        if (value.length() < minModelLength) {
            throw new IllegalArgumentException(String.format(Constants.IncorrectModelLengthMessage, minModelLength));
        }
    }
}
