package christmas.entity.Event;

import christmas.entity.Menu;
import christmas.entity.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FreeGiftEventTest {
    @DisplayName("해당 날짜의 할인 금액을 확인한다.")
    @Test
    void checkDiscountByTotalOrderAmount() {
        Order order = new Order(new String[]{"아이스크림-2", "초코케이크-4", "티본스테이크-3"});
        assertThat(new FreeGiftEvent(30, order).getDiscount()).isEqualTo(Menu.샴페인.getPrice());
    }
}