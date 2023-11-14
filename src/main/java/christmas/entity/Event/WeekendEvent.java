package christmas.entity.Event;

import christmas.entity.Order;

public class WeekendEvent extends Event {
    public WeekendEvent(int date, Order order) {
        super("주말 할인", date, order);
        this.discount = calculateDiscount();
    }

    protected int calculateDiscount() {
        if (5 <= reservationDayOfWeek && reservationDayOfWeek <= 6) {
            return super.order.getNumberOfMainMenu() * 2023;
        }

        return 0;
    }
}
