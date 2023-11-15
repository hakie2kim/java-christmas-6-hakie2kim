package christmas.entity.Event;

import christmas.entity.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SpecialEventTest {
    @DisplayName("해당 날짜의 할인 금액을 확인한다.")
    @ParameterizedTest
    @CsvSource({"25,1000", "24,1000", "23,0"})
    void checkDiscountByDate(int date, int discount) {
        Order order = new Order(new String[]{"아이스크림-2", "초코케이크-4", "티본스테이크-1"});
        assertThat(new SpecialEvent(date, order).getDiscount()).isEqualTo(discount);
    }

    @DisplayName("이벤트의 혜택이 정해진 형식인지 확인한다.")
    @Test
    void checkEventInFormat() {
        Order order = new Order(new String[]{"해산물파스타-2", "시저샐러드-4"});
        assertThat(new SpecialEvent(24, order).toString())
                .isEqualTo("특별 할인: -1,000원");
    }
}