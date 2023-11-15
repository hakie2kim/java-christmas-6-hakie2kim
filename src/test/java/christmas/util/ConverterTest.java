package christmas.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @DisplayName("정수형으로 바뀔 수 없는 문자열을 변환한다.")
    @Test
    void inconvertibleStringToInteger() {
        assertThatThrownBy(() -> Converter.stringToInteger("Thirty-One", "[ERROR]"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR]");
    }

    @DisplayName("정수형으로 바꿀 수 있는 문자열을 변환한다.")
    @Test
    void convertibleStringToInteger() {
        assertDoesNotThrow(() -> Converter.stringToInteger("-32", "[SUCCESS]"));
    }

    @DisplayName("금액에 쉼표 구분과 원 단위를 적용한다.")
    @Test
    void convertAmountToCurrencyFormat() {
        assertThat(Converter.amountCurrencyFormatted(1233546)).isEqualTo("1,233,546원");
    }
}