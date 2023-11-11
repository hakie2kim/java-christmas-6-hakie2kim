package christmas.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {
    private HashMap<Menu, Integer> order = new HashMap<>();
    final static int totalLimitQuantities = 20;

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

        if (totalQuantities >= totalLimitQuantities) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 " + totalLimitQuantities + "개까지만 주문할 수 있습니다.");
        }
    }
}
