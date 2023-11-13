package christmas.util;

public class Converter {
    public static int stringToInteger(String beforeConversion, String errorMessage) {
        try {
            return Integer.parseInt(beforeConversion);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
