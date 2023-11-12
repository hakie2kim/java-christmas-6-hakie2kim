package christmas.entity.Event;

import java.time.LocalDate;

public abstract class Event {
//    private final static String[] TYPES = {"크리스마스 디데이 할인", "평일 할인", "주말 할인", "특별 할인", "증정 이벤트"};
    protected String name;
    protected int discount;

    protected LocalDate getLocalDate(int year, int month, int date) {
        return LocalDate.of(year, month, date);
    }

    public static void verifyDate(int date) {
        if (!(1 <= date && date <= 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    protected abstract int calculateDiscount(int date);
}
