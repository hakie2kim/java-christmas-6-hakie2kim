package christmas.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {
    @DisplayName("메뉴의 개수 0 이하 20 초과일 경우로 주문하기")
    @Test
    void createOrderByWrongQuantity() {
        assertThatThrownBy(() -> new Order(new String[]{"아이스크림-21", "해산물파스타-18"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 형식으로 주문하기")
    @Test
    void createOrderByWrongFormat() {
        assertThatThrownBy(() -> new Order(new String[]{"아이스크림-해산물파스타-2", "시저샐러드-4"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴를 한번에 20개 넘게 주문하기")
    @Test
    void createOrderByExceedingQuantityLimit() {
        assertThatThrownBy(() -> new Order(new String[]{"아이스크림-9", "시저샐러드-9", "해산물파스타-2"}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}