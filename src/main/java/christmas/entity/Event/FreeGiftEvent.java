package christmas.entity.Event;

import christmas.entity.Menu;
import christmas.entity.Order;

public class FreeGiftEvent extends Event {
    public final static String FREE_GIFT = "샴페인 1개";
    public FreeGiftEvent(int date, Order order) {
        super(date, order);
        this.discountBenefit = calculateDiscountBenefit();
    }

    protected int calculateDiscountBenefit() {
        if (isEligible()) {
            return Menu.샴페인.getPrice();
        }

        return 0;
    }

    private boolean isEligible() {
        return order.calculateTotalAmount() >= 120000;
    }

    public String getFreeGift() {
        if (isEligible()) {
            return FREE_GIFT;
        }

        return "없음";
    }

    @Override
    public String toString() {
        return "증정 이벤트";
    }
}
