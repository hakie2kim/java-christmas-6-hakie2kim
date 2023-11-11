package christmas.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    @DisplayName("존재하지 않는 메뉴를 확인한다.")
    @Test
    void createNonExistingMenu() {
        assertThat(Menu.has("알리오올리오")).isFalse();
    }

    @DisplayName("존재하는 메뉴를 확인한다.")
    @Test
    void createExistingMenu() {
        assertThat(Menu.has("티본스테이크")).isTrue();
    }
}