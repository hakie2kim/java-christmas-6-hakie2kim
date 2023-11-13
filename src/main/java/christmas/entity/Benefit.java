package christmas.entity;

import christmas.entity.Event.*;
import christmas.util.Converter;

import java.util.ArrayList;
import java.util.HashSet;

public class Benefit {
    private HashSet<Event> events = new HashSet<>();
    private FreeGiftEvent freeGiftEvent;
    private int totalDiscounts;
    private String badge;

    public Benefit(int expectedVisitingDate, Order order) {
        addAllEvents(expectedVisitingDate, order);
        this.totalDiscounts = calculateTotalDiscounts();
        this.badge = decideBadge();
    }

    private void addAllEvents(int expectedVisitingDate, Order order) {
        events.add(new ChristmasDdayEvent(expectedVisitingDate, order));
        freeGiftEvent = new FreeGiftEvent(expectedVisitingDate, order);
        events.add(freeGiftEvent);
        events.add(new SpecialEvent(expectedVisitingDate, order));
        events.add(new WeekdayEvent(expectedVisitingDate, order));
        events.add(new WeekendEvent(expectedVisitingDate, order));
    }

    private int calculateTotalDiscounts() {
        int totalDiscounts = 0;

        for (Event event : events) {
            totalDiscounts += event.getDiscount();
        }

        return totalDiscounts;
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
    public String getEventAndDiscounts() {
        StringBuffer eventAndDiscounts = new StringBuffer();

        for (Event event : events) {
            eventAndDiscounts.append(String.format("%s: -%s%n", event.toString(), Converter.amountCurrencyFormatted(event.getDiscount())));
        }

        if (getTotalDiscounts() == 0) {
            eventAndDiscounts = new StringBuffer("없음");
        }

        return eventAndDiscounts.toString();
    }

    public String getFreeGift() {
        return freeGiftEvent.getFreeGift();
    }

    public int getTotalDiscounts() {
        return totalDiscounts;
    }

    public String getBadge() {
        return badge;
    }

}