package christmas.entity.Event;

import christmas.entity.Order;

public class FreeGiftEvent extends Event {
    public final static String FREE_GIFT = "샴페인 1개";
    FreeGiftEvent(int date, Order order) {
        super(date, order);
        this.name = "증정 이벤트";
        this.discountBenefit = calculateDiscountBenefit();
    }

    protected int calculateDiscountBenefit() {
        if (order.calculateTotalAmount() >= 120000) {
            return 1000;
        }

        return 0;
    }
}
