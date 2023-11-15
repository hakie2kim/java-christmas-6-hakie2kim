package christmas.entity;

import christmas.util.Converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {
    private final static int TOTAL_LIMIT_QUANTITY = 20;
    private final ArrayList<Menu> menus = new ArrayList<Menu>();
    private final ArrayList<Integer> quantities = new ArrayList<Integer>();
    private final HashMap<Menu, Integer> purchase = new HashMap<>();

    public Order(String[] menuAndQuantityPairs) {
        validate(menuAndQuantityPairs);
    }

    private void validate(String[] menuAndQuantityPairs) {
        isProperFormat(menuAndQuantityPairs);
        extractMenuAndQuantity(menuAndQuantityPairs);
        isOverTotalLimitQuantities(quantities);
        Menu.containsOnlyDrinks(menus);
    }

    private void isProperFormat(String[] menuAndOrderQuantityPairs) {
        Pattern menuAndOrderQuantityPattern = Pattern.compile("([가-힣]+)-([1-9]|1[0-9]|20)");

        for (String menuAndOrderQuantityPair : menuAndOrderQuantityPairs) {
            Matcher menuAndOrderQuantityMatcher = menuAndOrderQuantityPattern.matcher(menuAndOrderQuantityPair);

            if (!(menuAndOrderQuantityMatcher.matches())) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void extractMenuAndQuantity(String[] menuAndQuantityPairs) {
        for (String menuAndQuantityPair : menuAndQuantityPairs) {
            String[] menuAndQuantity = menuAndQuantityPair.split("-");
            Menu.has(menuAndQuantity[0]);
            Menu menu = Enum.valueOf(Menu.class, menuAndQuantity[0]);
            Integer quantity = Converter.stringToInteger(menuAndQuantity[1], "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

            if (purchase.containsKey(menu)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            menus.add(menu);
            quantities.add(quantity);
            purchase.put(menu, quantity);
        }
    }

    private void isOverTotalLimitQuantities(ArrayList<Integer> quantities) {
        int totalQuantities = quantities.stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (totalQuantities > TOTAL_LIMIT_QUANTITY) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 " + TOTAL_LIMIT_QUANTITY + "개까지만 주문할 수 있습니다.");
        }
    }

    public int getNumberOfMenu(String type) {
        return purchase.entrySet().stream()
                .filter(entry -> entry.getKey().getType().equals(type))
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    private int calculateTotalAmountBeforeDiscounts() {
        return purchase.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int getTotalAmountBeforeDiscounts() {
        return calculateTotalAmountBeforeDiscounts();
    }

    public HashMap<Menu, Integer> getPurchase() {
        return purchase;
    }
}
