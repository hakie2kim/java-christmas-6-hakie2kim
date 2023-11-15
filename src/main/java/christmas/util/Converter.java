package christmas.util;

import java.text.DecimalFormat;

public class Converter {
    public static int stringToInteger(String beforeConversion, String message) {
        try {
            return Integer.parseInt(beforeConversion);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(message);
        }
    }

    public static String amountCurrencyFormatted(int amount) {
        String formattedAmount = new DecimalFormat("#,###").format(amount);
        return String.format("%s원", formattedAmount);
    }
}
