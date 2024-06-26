package christmas.entity.Event;

import christmas.entity.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ChristmasDdayEventTest {
    @DisplayName("해당 날짜의 할인 금액을 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "1,1000", "2,1100", "3,1200", "4,1300", "5,1400", "6,1500", "7,1600", "8,1700",
            "9,1800", "10,1900", "11,2000", "12,2100", "13,2200", "14,2300", "15,2400", "16,2500",
            "17,2600", "18,2700", "19,2800", "20,2900", "21,3000", "22,3100", "23,3200", "24,3300",
            "25,3400"
    })
    void checkDiscountByDate(int date, int discount) {
        Order order = new Order(new String[]{"해산물파스타-2", "시저샐러드-4"});
        assertThat(new ChristmasDdayEvent(date, order).getDiscount()).isEqualTo(discount);
    }

    @DisplayName("이벤트의 혜택이 정해진 형식인지 확인한다.")
    @Test
    void checkEventInFormat() {
        Order order = new Order(new String[]{"해산물파스타-2", "시저샐러드-4"});
        assertThat(new ChristmasDdayEvent(12, order).toString())
                .isEqualTo("크리스마스 디데이 할인: -2,100원");
    }
}