package christmas.entity.Event;

import christmas.entity.Order;

public class ChristmasDdayEvent extends Event {
    ChristmasDdayEvent(int date, Order order) {
        super(date, order);
        this.discountBenefit = calculateDiscountBenefit();
    }

    protected int calculateDiscountBenefit() {
        if (super.date > 25) {
            return 0;
        }

        return 1000 + (super.date - 1) * 100;
    }

    @Override
    public String toString() {
        return "크리스마스 디데이 할인";
    }
}
