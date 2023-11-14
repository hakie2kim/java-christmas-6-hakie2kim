package christmas;

import christmas.entity.Benefit;
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

            int expectedVisitingDate = Converter.stringToInteger(Input.readExpectedVisitingDate(), "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

            Output.printMenu();
            Output.printCautions();
            order = new Order(Input.readOrder());

            benefit = new Benefit(expectedVisitingDate, order);

            Output.printExpectedVisitingDate(expectedVisitingDate);
            Output.printMenuOrdered(order.getOrder());
            Output.printTotalAmountBeforeDiscount(order.calculateTotalAmountBeforeDiscount());
            Output.printFreeGift(benefit.getFreeGift());
            Output.printBenefits(benefit.getEvents());
            Output.printTotalDiscountBenefit(benefit.getTotalDiscounts());
            Output.printTotalAmountAfterDiscount(calculateTotalAmountAfterDiscount());
            Output.printBadge(benefit.getBadge());
        } catch (IllegalArgumentException illegalArgumentException) {
            Output.printErrorMessage(illegalArgumentException.getMessage());
        }
    }

    private int calculateTotalAmountAfterDiscount() {
        return order.calculateTotalAmountBeforeDiscount() - benefit.getTotalDiscounts();
    }

}
