package christmas.entity.Event;

import christmas.entity.Order;

public class WeekendEvent extends Event {
    WeekendEvent(int date, Order order) {
        super(date, order);
        this.name = "주말 할인";
        this.discount = calculateDiscount();
    }

    protected int calculateDiscount() {
        if (4 <= reservationDayOfWeek && reservationDayOfWeek <= 7) {
            return super.order.getNumberOfMainMenu() * 2023;
        }

        return 0;
    }
}
