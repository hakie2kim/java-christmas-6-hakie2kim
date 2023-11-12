package christmas.entity.Event;

import christmas.entity.Order;

public class WeekendEvent extends Event {
    WeekendEvent(int date, Order order) {
        super(date, order);
        this.discountBenefit = calculateDiscountBenefit();
    }

    protected int calculateDiscountBenefit() {
        if (5 <= reservationDayOfWeek && reservationDayOfWeek <= 6) {
            return super.order.getNumberOfMainMenu() * 2023;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "주말 할인";
    }
}
