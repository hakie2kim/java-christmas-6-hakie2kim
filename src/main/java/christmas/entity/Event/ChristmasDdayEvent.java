package christmas.entity.Event;

import christmas.entity.Order;

public class ChristmasDdayEvent extends Event {
    ChristmasDdayEvent(int date, Order order) {
        super(date, order);
        this.name = "크리스마스 디데이 할인";
        this.discount = calculateDiscount(date);
    }

    protected int calculateDiscount(int date) {
        if (date > 25) {
            return 0;
        }

        return 1000 + (date - 1) * 100;
    }
}
