package christmas.entity.Event;

import christmas.entity.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SpecialEventTest {
    @DisplayName("해당 날짜의 할인 금액을 확인한다.")
    @ParameterizedTest
    @CsvSource({"25,1000", "24,1000", "23,0"})
    void checkDiscountByDate(int date, int discount) {
        Order order = new Order(new String[]{"아이스크림-2", "초코케이크-4", "티본스테이크-1"});
        assertThat(new SpecialEvent(date, order).getDiscount()).isEqualTo(discount);
    }
}