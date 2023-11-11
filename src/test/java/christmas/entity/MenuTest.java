package christmas.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    @DisplayName("존재하지 않는 메뉴를 확인한다.")
    @Test
    void createNonExistingMenu() {
        assertThatThrownBy(() -> Menu.has("알리오올리오")).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하는 메뉴를 확인한다.")
    @Test
    void createExistingMenu() {
        assertDoesNotThrow(() -> Menu.has("티본스테이크"));
    }

    @DisplayName("메뉴에 음료만 있는지 확인한다.")
    @Test
    void createMenuOnlyWithDrinks() {
        Menu zeroCoke = Enum.valueOf(Menu.class, "제로콜라");
        Menu champagne = Enum.valueOf(Menu.class, "샴페인");

        assertThatThrownBy(() -> Menu.containsOnlyDrinks(Arrays.asList(zeroCoke, champagne))).
                isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴에 음료 외 다른 메뉴가 있는지 확인한다.")
    @Test
    void createMenuWithOtherTypes() {
        Menu zeroCoke = Enum.valueOf(Menu.class, "제로콜라");
        Menu champagne = Enum.valueOf(Menu.class, "샴페인");
        Menu tboneSteak = Enum.valueOf(Menu.class, "티본스테이크");

        assertDoesNotThrow(() -> Menu.containsOnlyDrinks(Arrays.asList(zeroCoke, champagne, tboneSteak)));
    }
}