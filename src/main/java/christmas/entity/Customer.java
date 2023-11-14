package christmas.entity;

public class Customer {
    private int expectedVisitingDate;
    private Order order;
    private Benefit benefit;

    public Customer(int expectedVisitingDate, Order order) {
        this.expectedVisitingDate = expectedVisitingDate;
        this.order = order;
        this.benefit = new Benefit(expectedVisitingDate, order);
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
