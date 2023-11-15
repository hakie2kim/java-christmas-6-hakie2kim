package christmas;

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
            readInputs();
            Customer customer = new Customer(expectedVisitingDate, order);
            printDetails(customer);
        } catch (IllegalArgumentException illegalArgumentException) {
            Output.printErrorMessage(illegalArgumentException.getMessage());
        }
    }

    private void readInputs() {
        int expectedVisitingDate = Converter.stringToInteger(Input.readExpectedVisitingDate(),
                "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        Event.verifyDate(expectedVisitingDate);
        this.expectedVisitingDate = expectedVisitingDate;
        order = new Order(Input.readOrder());
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
