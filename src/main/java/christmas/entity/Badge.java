package christmas.entity;

import christmas.entity.Event.Event;

import java.util.List;

public class Badge {
    private List<Event> events;
    private int totalDiscountBenefit;

    public Badge(List<Event> events) {
        this.events = events;
        this.totalDiscountBenefit = calculateTotalDiscountBenefit();
    }

    private int calculateTotalDiscountBenefit() {
        int totalDiscountBenefit = 0;

        for (Event event : events) {
            totalDiscountBenefit += event.getDiscountBenefit();
        }

        return totalDiscountBenefit;
    }

    public int getTotalDiscountBenefit() {
        return totalDiscountBenefit;
    }

    @Override
    public String toString() {
        if (totalDiscountBenefit < 5000) {
            return "없음";
        }

        if (totalDiscountBenefit < 10000) {
            return "별";
        }

        if (totalDiscountBenefit < 20000) {
            return "트리";
        }

        return "산타";
    }
}
