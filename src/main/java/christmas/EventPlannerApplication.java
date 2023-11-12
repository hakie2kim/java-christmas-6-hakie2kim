package christmas;

import christmas.entity.Badge;
import christmas.entity.Event.*;
import christmas.entity.Order;
import christmas.view.Input;
import christmas.view.Output;

import java.util.ArrayList;
import java.util.Arrays;

public class EventPlannerApplication {
    private Order order;
    private Badge badge;
    private int expectedVisitingDate;
    private Event christmasDdayEvent;
    private Event freeGiftEvent;
    private Event specialEvent;
    private Event weekdayEvent;
    private Event weekendEvent;

    void execute() {
        Output.printWelcomeMessage();

        expectedVisitingDate = Integer.parseInt(Input.readExpectedVisitingDate());
        Output.printMenu();
        Output.printCautions();
        order = new Order(Input.readOrder());

        ArrayList<Event> events = new ArrayList<>();
        christmasDdayEvent = new ChristmasDdayEvent(expectedVisitingDate, order);
        freeGiftEvent = new FreeGiftEvent(expectedVisitingDate, order);
        specialEvent = new SpecialEvent(expectedVisitingDate, order);
        weekdayEvent = new WeekdayEvent(expectedVisitingDate, order);
        weekendEvent = new WeekendEvent(expectedVisitingDate, order);

        badge = new Badge(Arrays.asList(christmasDdayEvent, freeGiftEvent, specialEvent, weekdayEvent, weekendEvent));

        Output.printExpectedVisitingDate(expectedVisitingDate);
        Output.printMenuOrdered(order.getOrder());
        Output.printTotalAmountBeforeDiscount(order.calculateTotalAmountBeforeDiscount());
        Output.printFreeGift(specialEvent.toString());
        Output.printBenefits(badge.getBenefits());
        Output.printTotalDiscountBenefit(badge.getTotalDiscountBenefit());
        Output.printTotalAmountAfterDiscount(calculateTotalAmountAfterDiscount());
        Output.printBadge(badge.toString());
    }

    private int calculateTotalAmountAfterDiscount() {
        return order.calculateTotalAmountBeforeDiscount() - badge.getTotalDiscountBenefit();
    }

}
