package christmas.entity.Event;

import christmas.entity.Order;

public class SpecialEvent extends Event {
    public SpecialEvent(int date, Order order) {
        super("특별 할인", date, order);
        this.discount = calculateDiscount();
    }

    protected int calculateDiscount() {
        if (reservationDayOfWeek == 7 || date == 25) {
            return 1000;
        }

        return 0;
    }
}
