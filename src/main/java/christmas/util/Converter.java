package christmas.util;

import java.text.DecimalFormat;

public class Converter {
    public static int stringToInteger(String beforeConversion, String errorMessage) {
        try {
            return Integer.parseInt(beforeConversion);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static String amountCurrencyFormatted(int amount) {
        String formattedAmount = new DecimalFormat("#,###").format(amount);
        return String.format("%s원", formattedAmount);
    }
}
