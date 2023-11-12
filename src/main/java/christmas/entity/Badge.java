package christmas.entity;

import christmas.entity.Event.Event;

import java.util.ArrayList;

public class Badge {
    private ArrayList<Event> events;
    private int totalDiscountBenefit;

    Badge (ArrayList<Event> events) {
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
}
