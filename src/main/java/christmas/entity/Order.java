package christmas.entity;

import christmas.entity.Event.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {
//    private int date;
    private HashMap<Menu, Integer> order = new HashMap<>();
    private final static int TOTAL_LIMIT_QUANTITITY = 20;

    public Order(String[] menuAndQuantityPairs) {
        validate(menuAndQuantityPairs);
    }

    private void validate(String[] menuAndQuantityPairs) {
        isProperFormat(menuAndQuantityPairs);

        ArrayList<Menu> menus = new ArrayList<Menu>();
        ArrayList<Integer> quantities = new ArrayList<Integer>();

        for (String menuAndQuantityPair : menuAndQuantityPairs) {
            String[] menuAndQuantity = menuAndQuantityPair.split("-");

            Menu menu = Enum.valueOf(Menu.class, menuAndQuantity[0]);
            Integer quantity = Integer.parseInt(menuAndQuantity[1]);

            if (order.containsKey(menu)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            order.put(menu, quantity);

            menus.add(Enum.valueOf(Menu.class, menuAndQuantity[0]));
            quantities.add(Integer.parseInt(menuAndQuantity[1]));
        }

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

    private void isOverTotalLimitQuantities(ArrayList<Integer> quantities) {
        int totalQuantities = 0;

        for (Integer quantity : quantities) {
            totalQuantities += quantity;
        }

        if (totalQuantities >= TOTAL_LIMIT_QUANTITITY) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 " + TOTAL_LIMIT_QUANTITITY + "개까지만 주문할 수 있습니다.");
        }
    }

    public int getNumberOfDesertMenu() {
        int numberOfDessertMenu = 0;

        for (Menu menu : order.keySet()) {
            if (menu.getType().equals("디저트")) {
                numberOfDessertMenu += order.get(menu);
            }
        }

        return numberOfDessertMenu;
    }

    public int getNumberOfMainMenu() {
        int numberOfMainMenu = 0;

        for (Menu menu : order.keySet()) {
            if (menu.getType().equals("메인")) {
                numberOfMainMenu += order.get(menu);
            }
        }

        return numberOfMainMenu;
    }

    public int calculateTotalAmountBeforeDiscount() {
        int totalAmountBeforeBenefit = 0;

        for (Menu menu : order.keySet()) {
            totalAmountBeforeBenefit += menu.getPrice() * order.get(menu);
        }

        return totalAmountBeforeBenefit;
    }
    
}
