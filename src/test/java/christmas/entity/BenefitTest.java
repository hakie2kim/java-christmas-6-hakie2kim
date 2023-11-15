package christmas.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BenefitTest {
    private final int expectedVisitingDate = 30;
    private Order order = new Order(new String[]{"아이스크림-2", "초코케이크-4", "티본스테이크-3"});

    @DisplayName("총 혜택 금액을 확인한다.")
    @Test
    void checkTotalDiscountBenefit() {
        assertThat(new Benefit(expectedVisitingDate, order).getTotalDiscounts()).isEqualTo(31069);
    }

    @DisplayName("이벤트 배지를 확인한다.")
    @Test
    void createEventBadgeBySanta() {
        assertThat(new Benefit(expectedVisitingDate, order).getBadge()).isEqualTo("산타");
    }
}