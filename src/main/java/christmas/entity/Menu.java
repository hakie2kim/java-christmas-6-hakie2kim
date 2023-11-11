package christmas.entity;

import java.util.ArrayList;
import java.util.List;

public enum Menu {
//    MUSHROOM_CREAM_SOUP("애피타이저","양송이스프",  6000),
//    TAPAS("애피타이저", "타파스", 5500),
//    CAESAR_SALAD("애피타이저", "시저샐러드", 8000),
//    T_BONE_STEAK("메인", "티본스테이크", 55000),
//    BARBEQUE_RIP("메인", "바비큐립", 54000),
//    SEAFOOD_PASTA("메인", "해산물파스타", 35000),
//    CHRISTMAS_PASTA("메인", "크리스마스파스타", 25000),
//    CHOCOLATE_CAKE("디저트", "초코케이크", 15000),
//    ICECREAM("디저트", "아이스크림", 5000),
//    COKE_ZERO("음료", "제로콜라", 3000),
//    RED_WINE("음료", "레드와인", 60000),
//    CHAMPAGNE("음료", "샴페인", 25000);

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

    private String type;
    private int price;

    Menu(String type, int price) {
        this.type = type;
        this.price = price;
    }

    public static ArrayList<String> names() {
        Menu[] menus = values();
        ArrayList<String> names = new ArrayList<>();

        for (Menu menu : menus) {
            names.add(menu.name());
        }

        return names;
    }

//    public static ArrayList<Menu> drinks() {
//        Menu[] menus = values();
//        ArrayList<Menu> drinks = new ArrayList<>();
//
//        for (Menu menu : menus) {
//            if (menu.getType().equals("음료")) {
//                drinks.add(menu);
//            }
//        }
//
//        return drinks;
//    }

    public static void has(String name) {
        if (!(names().contains(name))) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void containsOnlyDrinks(List<Menu> menus) {
        for (Menu menu : menus) {
            if ((menu.getType().equals("애피타이저") || menu.getType().equals("메인") || menu.getType().equals("디저트"))) {
                return;
            }
        }

        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
