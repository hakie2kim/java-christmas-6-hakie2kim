package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Input {
    public static String[] readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        return Console.readLine().trim().split(","); // PatternSyntaxException
    }

}
