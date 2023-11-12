package christmas.entity.Event;

import christmas.entity.Order;

public class WeekdayEvent extends Event {
    public WeekdayEvent(int date, Order order) {
        super(date, order);
        this.discountBenefit = calculateDiscountBenefit();
    }

    protected int calculateDiscountBenefit() {
        if (reservationDayOfWeek == 7 || 1 <= reservationDayOfWeek && reservationDayOfWeek <= 4) {
            return super.order.getNumberOfDesertMenu() * 2023;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "평일 할인";
    }
}
