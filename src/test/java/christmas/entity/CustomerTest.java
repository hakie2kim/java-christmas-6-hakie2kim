package christmas.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @DisplayName("혜택 적용 후 금액을 확인한다.")
    @Test
    void checkTotalAmountAfterDiscount() {
        Order order = new Order(new String[]{"아이스크림-2", "초코케이크-4", "티본스테이크-3"});
        assertThat(new Customer(30, order)
                .getTotalAmountAfterDiscounts())
                .isEqualTo(203931);
    }
}