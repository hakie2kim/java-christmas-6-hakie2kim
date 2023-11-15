package christmas.view;

import christmas.entity.Event.Event;
import christmas.entity.Menu;
import christmas.util.Converter;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;

public class Output {
    public static void printWelcomeMessage(int month) {
        System.out.println("안녕하세요! 우테코 식당 " + month + "월 이벤트 플래너입니다.");
    }

    public static void printMenu() {
        System.out.println("<메뉴판>");
        System.out.println();
        System.out.println("<애피타이저>");
        System.out.println("양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)");
        System.out.println();
        System.out.println("<메인>");
        System.out.println("티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)");
        System.out.println();
        System.out.println("<디저트>");
        System.out.println("초코케이크(15,000), 아이스크림(5,000)");
        System.out.println();
        System.out.println("<음료>");
        System.out.println("제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)");
        System.out.println();
    }

    public static void printCautions() {
        System.out.println("<주의사항>");
        System.out.println("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.");
        System.out.println("음료만 주문 시, 주문할 수 없습니다.");
        System.out.println("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        System.out.println();
    }

    public static void printExpectedVisitingDate(int expectedVisitingDate) {
        System.out.println("12월 " + expectedVisitingDate + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public static void printOrderPurchase(HashMap<Menu, Integer> order) {
        System.out.println("<주문 메뉴>");
        order.forEach((menu, quantity) -> System.out.printf("%s %d개%n", menu.name(), quantity));
        System.out.println();
    }

    public static void printTotalAmountBeforeDiscounts(int totalAmountBeforeDiscounts) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(Converter.amountCurrencyFormatted(totalAmountBeforeDiscounts));
        System.out.println();
    }

    public static void printFreeGift(String freeGift) {
        System.out.println("<증정 메뉴>");
        System.out.println(freeGift);
        System.out.println();
    }

    public static void printBenefitEvents(HashSet<Event> events) {
        System.out.println("<혜택 내역>");

        if (events.stream().allMatch(event -> event.toString().isEmpty())) {
            System.out.println("없음");
            System.out.println();
            return;
        }

        events.stream().filter(event -> !(event.toString().isEmpty())).forEach(System.out::println);
        System.out.println();
    }

    public static void printTotalDiscounts(int totalDiscounts) {
        System.out.println("<총혜택 금액>");
        System.out.println(Converter.amountCurrencyFormatted(totalDiscounts));
        System.out.println();
    }

    public static void printTotalAmountAfterDiscounts(int totalAmountAfterDiscounts) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(Converter.amountCurrencyFormatted(totalAmountAfterDiscounts));
        System.out.println();
    }

    public static void printBadge(String badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
