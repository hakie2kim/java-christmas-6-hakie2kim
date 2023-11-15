package christmas.entity;

import java.util.HashSet;
import java.util.List;

public enum Menu {
    양송이스프("애피타이저", 6000),
    타파스("애피타이저", 5500),
    시저샐러드("애피타이저", 8000),
    티본스테이크("메인", 55000),
    바비큐립("메인", 54000),
    해산물파스타("메인", 35000),
    크리스마스파스타("메인", 25000),
    초코케이크("디저트", 15000),
    아이스크림("디저트", 5000),
    제로콜라("음료", 3000),
    레드와인("음료", 60000),
    샴페인("음료", 25000);

    private final String type;
    private final int price;

    Menu(String type, int price) {
        this.type = type;
        this.price = price;
    }

    private static HashSet<String> names() {
        Menu[] menus = values();
        HashSet<String> names = new HashSet<>();
        for (Menu menu : menus) {
            names.add(menu.name());
        }
        return names;
    }

    public static void has(String name) {
        if (!(names().contains(name))) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private static boolean containsOtherThanDrinks(List<Menu> menus) {
        return menus.stream()
                .anyMatch(menu ->
                        menu.getType().equals("애피타이저") ||
                                menu.getType().equals("메인") ||
                                menu.getType().equals("디저트")
                );
    }

    public static void containsOnlyDrinks(List<Menu> menus) {
        if (containsOtherThanDrinks(menus)) { // 애피타이저, 메인, 디저트를 포함하고 있다면 예외를 발생하지 않는다.
            return;
        }
        throw new IllegalArgumentException("[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요.");
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
