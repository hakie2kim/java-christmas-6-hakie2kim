package christmas.entity.Event;

import christmas.entity.Order;

public class SpecialEvent extends Event {
    public SpecialEvent(int date, Order order) {
        super("특별 할인", date, order);
        this.discount = calculateDiscount();
    }

    protected int calculateDiscount() {
        if (super.reservationDayOfWeek == 7 || super.DATE == 25) { // 일요일이거나 크리스마스인 경우
            return 1000;
        }
        return 0;
    }
}
