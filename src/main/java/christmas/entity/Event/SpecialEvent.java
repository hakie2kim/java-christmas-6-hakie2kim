package christmas.entity.Event;

import christmas.entity.Order;

public class SpecialEvent extends Event {
    public SpecialEvent(int date, Order order) {
        super(date, order);
        this.discountBenefit = calculateDiscountBenefit();
    }

    protected int calculateDiscountBenefit() {
        if (reservationDayOfWeek == 7 || date == 25) {
            return 1000;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "특별 할인";
    }
}
