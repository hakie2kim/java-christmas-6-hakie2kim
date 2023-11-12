package christmas.entity.Event;

import java.time.LocalDate;

public class ChristmasDdayEvent extends Event {
    ChristmasDdayEvent(int date) {
        verifyDate(date);
        this.name = "크리스마스 디데이 할인";
        this.discount = calculateDiscount(date);
    }

    protected int calculateDiscount(int date) {
        if (date > 25) {
            return 0;
        }

        return 1000 + (date - 1) * 100;
    }
}
