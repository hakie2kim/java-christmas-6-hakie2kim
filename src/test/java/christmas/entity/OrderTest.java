package christmas.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class OrderTest {
    @DisplayName("잘못된 형식으로 주문하기")
    @Test
    void createOrderByWrongFormat() {
        assertThatThrownBy(() -> new Order(new String[]{"아이스크림-해산물파스타-2", "시저샐러드-4"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴의 개수 0 이하 20 초과일 경우로 주문하기 (잘못된 형식)")
    @Test
    void createOrderByWrongQuantity() {
        assertThatThrownBy(() -> new Order(new String[]{"아이스크림-21", "해산물파스타--30"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("중복된 메뉴를 포함하여 주문하기")
    @Test
    void createOrderByDuplicateMenu() {
        assertThatThrownBy(() -> new Order(new String[]{"해산물파스타-2", "해산물파스타-4"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @DisplayName("메뉴를 한번에 20개 넘게 주문하기")
    @Test
    void createOrderByExceedingQuantityLimit() {
        assertThatThrownBy(() -> new Order(new String[]{"아이스크림-9", "시저샐러드-9", "해산물파스타-3"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 메뉴는 한 번에 최대");
        ;
    }

    @DisplayName("정상적으로 주문하기")
    @Test
    void createCorrectOrder() {
        assertDoesNotThrow(() -> new Order(new String[]{"해산물파스타-2", "시저샐러드-4"}));
    }

    @DisplayName("디저트 메뉴의 개수 확인하기")
    @Test
    void createOrderByFourDessertMenu() {
        assertThat(new Order(new String[]{"티본스테이크-1", "아이스크림-3", "초코케이크-1"}).getNumberOfMenu("디저트"))
                .isEqualTo(4);
    }

    @DisplayName("메인 메뉴의 개수 확인하기")
    @Test
    void createOrderByFiveMainMenu() {
        assertThat(new Order(new String[]{"바비큐립-1", "크리스마스파스타-4", "초코케이크-1"}).getNumberOfMenu("메인"))
                .isEqualTo(5);
    }

    @DisplayName("총 주문 금액 확인하기")
    @Test
    void checkTotalAmountOfOrder() {
        assertThat(new Order(new String[]{"바비큐립-1", "크리스마스파스타-4", "초코케이크-1"}).getTotalAmountBeforeDiscounts())
                .isEqualTo(169000);
    }
}