package christmas.entity.Event;

import christmas.entity.Order;

public class WeekendEvent extends Event {
    public WeekendEvent(int date, Order order) {
        super("주말 할인", date, order);
        this.discount = calculateDiscount();
    }

    protected int calculateDiscount() {
        // 금-토요일인 경우
        if (5 <= super.RESERVATION_DAY_OF_WEEK && super.RESERVATION_DAY_OF_WEEK <= 6) {
            return super.ORDER.getNumberOfMenu("메인") * 2023;
        }
        return 0;
    }
}
