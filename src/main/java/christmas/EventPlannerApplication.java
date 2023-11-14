package christmas;

import christmas.entity.Benefit;
import christmas.entity.Customer;
import christmas.entity.Order;
import christmas.util.Converter;
import christmas.view.Input;
import christmas.view.Output;

public class EventPlannerApplication {
    private Order order;
    private Benefit benefit;

    void execute() {
        try {
            Output.printWelcomeMessage();
            Output.printMenu();
            Output.printCautions();

            Customer customer = new Customer(
                    Converter.stringToInteger(Input.readExpectedVisitingDate(), "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
                    new Order(Input.readOrder())
            );

            Output.printExpectedVisitingDate(customer.getExpectedVisitingDate());
            Output.printMenuOrdered(customer.getOrder().getPurchase());
            Output.printTotalAmountBeforeDiscount(customer.getOrder().getTotalAmountBeforeDiscounts());
            Output.printFreeGift(customer.getBenefit().getFreeGift());
            Output.printBenefits(customer.getBenefit().getEvents());
            Output.printTotalDiscountBenefit(customer.getBenefit().getTotalDiscounts());
            Output.printTotalAmountAfterDiscount(customer.getTotalAmountAfterDiscounts());
            Output.printBadge(customer.getBenefit().getBadge());
        } catch (IllegalArgumentException illegalArgumentException) {
            Output.printErrorMessage(illegalArgumentException.getMessage());
        }
    }
}
