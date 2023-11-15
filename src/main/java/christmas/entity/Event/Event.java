package christmas.entity.Event;

import christmas.entity.Order;
import christmas.util.Converter;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public abstract class Event {
    private final static int YEAR = 2023;
    public final static int MONTH = 12;
    public final static int LAST_DAY_OF_MONTH;
    protected final int reservationDayOfWeek; // 월요일 1부터 일요일 7까지
    protected final String NAME;
    protected final int date;
    protected final Order order;
    protected int discount;

    static {
        LAST_DAY_OF_MONTH = LocalDate.of(YEAR, MONTH, 1)
                .with(TemporalAdjusters.lastDayOfMonth())
                .getDayOfMonth();
    }

    protected Event(String name, int date, Order order) {
        NAME = name;
        verifyDate(date);
        this.date = date;
        this.reservationDayOfWeek = getDayOfWeek(date);
        this.order = order;
    }

    protected int getDayOfWeek(int date) {
        return LocalDate.of(YEAR, MONTH, date).getDayOfWeek().getValue();
    }

    public static void verifyDate(int date) {
        if (!(1 <= date && date <= LAST_DAY_OF_MONTH)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    protected abstract int calculateDiscount();

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        if (getDiscount() != 0) {
            return (String.format("%s: -%s", NAME, Converter.amountCurrencyFormatted(getDiscount())));
        }
        return ""; // 할인(혜택)이 없는 경우
    }
}
