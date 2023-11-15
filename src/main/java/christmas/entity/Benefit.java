package christmas.entity;

import christmas.entity.Event.*;
import christmas.util.Converter;

import java.util.HashSet;

public class Benefit {
    private final HashSet<Event> events = new HashSet<>();
    private FreeGiftEvent freeGiftEvent;
    private final int totalDiscounts;
    private final String badge;

    public Benefit(int expectedVisitingDate, Order order) {
        addEvents(expectedVisitingDate, order);
        this.totalDiscounts = calculateTotalDiscounts();
        this.badge = decideBadge();
    }

    private void addEvents(int expectedVisitingDate, Order order) {
        events.add(new ChristmasDdayEvent(expectedVisitingDate, order));
        freeGiftEvent = new FreeGiftEvent(expectedVisitingDate, order);
        events.add(freeGiftEvent);
        events.add(new SpecialEvent(expectedVisitingDate, order));
        events.add(new WeekdayEvent(expectedVisitingDate, order));
        events.add(new WeekendEvent(expectedVisitingDate, order));
    }

    private int calculateTotalDiscounts() {
        return events.stream()
                .mapToInt(Event::getDiscount)
                .sum();
    }

    private String decideBadge() {
        if (totalDiscounts < 5000) {
            return "없음";
        }
        if (totalDiscounts < 10000) {
            return "별";
        }
        if (totalDiscounts < 20000) {
            return "트리";
        }
        return "산타";
    }

    public HashSet<Event> getEvents() {
        return events;
    }

    public FreeGiftEvent getFreeGiftEvent() {
        return freeGiftEvent;
    }

    public int getTotalDiscounts() {
        return totalDiscounts;
    }

    public String getBadge() {
        return badge;
    }
}
