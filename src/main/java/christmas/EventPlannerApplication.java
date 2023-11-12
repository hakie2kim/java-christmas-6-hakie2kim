package christmas;

import christmas.entity.Badge;
import christmas.entity.Event.*;
import christmas.entity.Order;
import christmas.view.Input;

import java.util.ArrayList;

public class EventPlannerApplication {
    private Order order;
    private Badge badge;

    void execute() {
        order = new Order(Input.readOrder());

        ArrayList<Event> events = new ArrayList<>();
        events.add(new ChristmasDdayEvent(30, order));
        events.add(new FreeGiftEvent(30, order));
        events.add(new SpecialEvent(30, order));
        events.add(new WeekdayEvent(30, order));
        events.add(new WeekendEvent(30, order));

        badge = new Badge(events);
    }

    private int calculateTotalAmountAfterDiscount() {
        return order.calculateTotalAmountBeforeDiscount() - badge.getTotalDiscountBenefit();
    }

}
