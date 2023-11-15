package christmas.entity;

import christmas.entity.Event.Event;

public class Customer {
    private final int expectedVisitingDate;
    private final Order order;
    private final Benefit benefit;

    public Customer(int expectedVisitingDate, Order order) {
        this.expectedVisitingDate = expectedVisitingDate;
        this.order = order;
        this.benefit = new Benefit(this.expectedVisitingDate, order);
    }

    public int getExpectedVisitingDate() {
        return expectedVisitingDate;
    }

    public Order getOrder() {
        return order;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    private int calculateTotalAmountAfterDiscounts() {
        return order.getTotalAmountBeforeDiscounts() - benefit.getTotalDiscounts();
    }

    public int getTotalAmountAfterDiscounts() {
        return calculateTotalAmountAfterDiscounts();
    }
}
