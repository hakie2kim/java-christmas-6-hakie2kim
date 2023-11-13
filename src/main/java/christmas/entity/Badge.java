package christmas.entity;

import christmas.entity.Event.Event;

import java.util.HashMap;
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
            totalDiscountBenefit += event.getDiscount();
        }

        return totalDiscountBenefit;
    }

    public int getTotalDiscountBenefit() {
        return totalDiscountBenefit;
    }

    public HashMap<String, Integer> getBenefits() {
        HashMap<String, Integer> benefits = new HashMap<>();
        for (Event event : events) {
            benefits.put(event.toString(), event.getDiscount());
        }

        return benefits;
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
