package christmas.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {
    @DisplayName("잘못된 메뉴의 개수 0 이하 20 초과일 경우로 주문하기")
    @Test
    void createOrderByWrongQuantity() {
        assertThatThrownBy(() -> new Order(new String[]{"파스타-21", "파스타-18"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 형식으로 주문하기")
    @Test
    void createOrderByWrongFormat() {
        assertThatThrownBy(() -> new Order(new String[]{"파스타-샐러드-2", "스테이크-4"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("없는 메뉴 주문하기")
    @Test
    void createOrderByWrongMenu() {
        assertThatThrownBy(() -> new Order(new String[]{"파스타-2", "바비큐립-4"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

}