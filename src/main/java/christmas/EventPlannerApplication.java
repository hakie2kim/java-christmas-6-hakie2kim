package christmas;

import christmas.controller.InputController;
import christmas.entity.Benefit;
import christmas.entity.Customer;
import christmas.entity.Event.Event;
import christmas.entity.Order;
import christmas.util.Converter;
import christmas.view.Input;
import christmas.view.Output;

public class EventPlannerApplication {
    private int expectedVisitingDate;
    private Order order;

    void execute() {
        try {
            printWelcome();
            Customer customer = new Customer(
                    InputController.setExpectedVisitingDate(),
                    InputController.setOrder()
            );
            printDetails(customer);
        } catch (IllegalArgumentException illegalArgumentException) {
            Output.printErrorMessage(illegalArgumentException.getMessage());
        }
    }

    private void printWelcome() {
        Output.printWelcomeMessage(Event.MONTH);
        Output.printMenu();
        Output.printCautions();
    }

    private void printDetails(Customer customer) {
        Output.printExpectedVisitingDate(customer.getExpectedVisitingDate());
        Output.printOrderPurchase(customer.getOrder().getPurchase());
        Output.printTotalAmountBeforeDiscounts(customer.getOrder().getTotalAmountBeforeDiscounts());
        Output.printFreeGift(customer.getBenefit().getFreeGiftEvent().getFreeGift());
        Output.printBenefitEvents(customer.getBenefit().getEvents());
        Output.printTotalDiscounts(customer.getBenefit().getTotalDiscounts());
        Output.printTotalAmountAfterDiscounts(customer.getTotalAmountAfterDiscounts());
        Output.printBadge(customer.getBenefit().getBadge());
    }
}
