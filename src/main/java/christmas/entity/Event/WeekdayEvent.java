package christmas.entity.Event;

import christmas.entity.Order;

public class WeekdayEvent extends Event {
    public WeekdayEvent(int date, Order order) {
        super("평일 할인", date, order);
        this.discount = calculateDiscount();
    }

    protected int calculateDiscount() {
        // 월-목, 일요일인 경우
        if (super.RESERVATION_DAY_OF_WEEK == 7 ||
                1 <= super.RESERVATION_DAY_OF_WEEK && super.RESERVATION_DAY_OF_WEEK <= 4) {
            return super.ORDER.getNumberOfMenu("디저트") * 2023;
        }
        return 0;
    }
}
