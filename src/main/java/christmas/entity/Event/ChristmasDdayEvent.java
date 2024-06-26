package christmas.entity.Event;

import christmas.entity.Order;

public class ChristmasDdayEvent extends Event {
    public ChristmasDdayEvent(int date, Order order) {
        super("크리스마스 디데이 할인", date, order);
        this.discount = calculateDiscount();
    }

    protected int calculateDiscount() {
        if (super.date > 25) { // 크리스마스를 지난 경우
            return 0;
        }
        return 1000 + (super.date - 1) * 100;
    }
}
