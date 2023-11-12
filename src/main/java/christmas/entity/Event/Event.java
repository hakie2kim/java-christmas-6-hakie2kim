package christmas.entity.Event;

import christmas.entity.Order;

import java.time.LocalDate;

public abstract class Event {
//    private final static String[] TYPES = {"크리스마스 디데이 할인", "평일 할인", "주말 할인", "특별 할인", "증정 이벤트"};
    private final static int YEAR = 2023;
    private final static int MONTH = 12;
    protected final int reservationDayOfWeek;
    protected final int date;
    protected final Order order;
    protected int discountBenefit;

    protected Event(int date, Order order) {
        verifyDate(date);
        this.date = date;
        this.reservationDayOfWeek = getDayOfWeek(date);
        this.order = order;
    }

    protected int getDayOfWeek(int date) {
        return LocalDate.of(YEAR, MONTH, date).getDayOfWeek().getValue();
    }

    public static void verifyDate(int date) {
        if (!(1 <= date && date <= 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    protected abstract int calculateDiscountBenefit();

    public int getDiscount() {
        return discountBenefit;
    }
}
