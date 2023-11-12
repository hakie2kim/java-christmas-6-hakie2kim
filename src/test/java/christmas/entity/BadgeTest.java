package christmas.entity;

import christmas.entity.Event.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {
    private ArrayList<Event> events = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Order order = new Order(new String[]{"아이스크림-2", "초코케이크-4", "티본스테이크-3"});
        events.add(new ChristmasDdayEvent(30, order));
        events.add(new FreeGiftEvent(30, order));
        events.add(new SpecialEvent(30, order));
        events.add(new WeekdayEvent(30, order));
        events.add(new WeekendEvent(30, order));
    }

    @DisplayName("총 혜택 금액을 확인한다.")
    @Test
    void checkTotalDiscountBenefit() {
        assertThat(new Badge(events).getTotalDiscountBenefit()).isEqualTo(31069);
    }

    @DisplayName("이벤트 배지를 확인한다.")
    @Test
    void checkEventBadgeBySanta() {
        assertThat(new Badge(events).toString()).isEqualTo("산타");
    }

}