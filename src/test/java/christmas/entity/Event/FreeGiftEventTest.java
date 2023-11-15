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

    @DisplayName("12만원 이상 구매 시 이벤트의 증정 내역을 확인한다.")
    @Test
    void createEventByFreeGiftEligible() {
        Order order = new Order(new String[]{"아이스크림-2", "초코케이크-4", "티본스테이크-3"});
        assertThat(new FreeGiftEvent(30, order).getFreeGift()).isEqualTo(FreeGiftEvent.PRIZE);
    }

    @DisplayName("12만원 미만 구매 시 이벤트의 증정 내역을 확인한다.")
    @Test
    void createEventByFreeGiftNotEligible() {
        Order order = new Order(new String[]{"아이스크림-1", "초코케이크-1", "티본스테이크-1"});
        assertThat(new FreeGiftEvent(30, order).getFreeGift()).isEqualTo("없음");
    }

    @DisplayName("이벤트의 혜택이 정해진 형식인지 확인한다.")
    @Test
    void checkEventInFormat() {
        Order order = new Order(new String[]{"아이스크림-2", "초코케이크-4", "티본스테이크-3"});
        assertThat(new FreeGiftEvent(12, order).toString())
                .isEqualTo("증정 이벤트: -25,000원");
    }
}