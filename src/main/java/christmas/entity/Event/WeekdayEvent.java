package christmas.entity.Event;

import christmas.entity.Order;

public class WeekdayEvent extends Event {
    WeekdayEvent(int date, Order order) {
        super(date, order);
        this.name = "평일 할인";
        this.discountBenefit = calculateDiscountBenefit();
    }

    protected int calculateDiscountBenefit() {
        if (reservationDayOfWeek == 7 || 1 <= reservationDayOfWeek && reservationDayOfWeek <= 4) {
            return super.order.getNumberOfDesertMenu() * 2023;
        }

        return 0;
    }
}
