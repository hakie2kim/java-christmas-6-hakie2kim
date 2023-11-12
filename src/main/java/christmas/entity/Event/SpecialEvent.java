package christmas.entity.Event;

import christmas.entity.Order;

public class SpecialEvent extends Event {
    SpecialEvent(int date, Order order) {
        super(date, order);
        this.name = "특별 할인";
        this.discount = calculateDiscount();
    }

    protected int calculateDiscount() {
        if (reservationDayOfWeek == 7 || date == 25) {
            return 1000;
        }

        return 0;
    }
}
