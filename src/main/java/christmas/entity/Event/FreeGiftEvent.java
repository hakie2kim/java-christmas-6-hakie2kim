package christmas.entity.Event;

import christmas.entity.Menu;
import christmas.entity.Order;

public class FreeGiftEvent extends Event {
    public final static String PRIZE = Menu.샴페인.name() + " 1개";
    public final static int AMOUNT_ELIGIBILITY = 120000;

    public FreeGiftEvent(int date, Order order) {
        super("증정 이벤트", date, order);
        this.discount = calculateDiscount();
    }

    private boolean isEligible() {
        return super.ORDER.getTotalAmountBeforeDiscounts() >= AMOUNT_ELIGIBILITY;
    }

    protected int calculateDiscount() {
        if (isEligible()) {
            return Menu.샴페인.getPrice();
        }
        return 0;
    }


    public String getFreeGift() {
        if (isEligible()) {
            return PRIZE;
        }
        return "없음";
    }
}
