package christmas.controller;

import christmas.entity.Event.Event;
import christmas.entity.Order;
import christmas.util.Converter;
import christmas.view.Input;
import christmas.view.Output;

public class InputController {
    public static int setExpectedVisitingDate() {
        try {
            int expectedVisitingDate = Converter.stringToInteger(Input.readExpectedVisitingDate(),
                    "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            Event.verifyDate(expectedVisitingDate);
            return expectedVisitingDate;
        } catch(IllegalArgumentException illegalArgumentException) {
            Output.printErrorMessage(illegalArgumentException.getMessage());
            return setExpectedVisitingDate();
        }
    }

    public static Order setOrder() {
        try {
            return new Order(Input.readOrder());
        } catch(IllegalArgumentException illegalArgumentException) {
            Output.printErrorMessage(illegalArgumentException.getMessage());
            return setOrder();
        }
    }
}
