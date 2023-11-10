package christmas.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {
    private HashMap<Menu, Integer> order;

    public Order(String[] menuAndQuantityPairs) {
        validate(menuAndQuantityPairs);
    }

    private void validate(String[] menuAndQuantityPairs) {
        isProperFormat(menuAndQuantityPairs);

        ArrayList<String> menus = new ArrayList<String>();
        ArrayList<Integer> quantities = new ArrayList<Integer>();

        for (String menuAndQuantityPair : menuAndQuantityPairs) {
            String[] menuAndQuantity = menuAndQuantityPair.split("-");
            menus.add(menuAndQuantity[0]);
            quantities.add(Integer.parseInt(menuAndQuantity[1]));
        }

        containsNonExistingMenu(menus);
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

    private void containsNonExistingMenu(ArrayList<String> menus) {
        for (String menu: menus) {
            if (!Menu.has(menu)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
}
