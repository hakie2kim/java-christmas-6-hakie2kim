package christmas.entity.Event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {
    @DisplayName("유효하지 않은 날짜로 이벤트를 확인한다.")
    @Test
    void createEventByInvalidDate() {
        assertThatThrownBy(() -> Event.verifyDate(32))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @DisplayName("유효한 날짜로 이벤트를 확인한다.")
    @Test
    void createEventByValidDate() {
        assertDoesNotThrow(() -> Event.verifyDate(31));
    }
}