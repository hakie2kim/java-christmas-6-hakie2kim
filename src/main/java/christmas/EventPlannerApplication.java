package christmas;

import christmas.entity.Order;
import christmas.view.Input;

public class EventPlannerApplication {
    void execute() {
        String[] order = Input.readOrder();
        new Order(order);
    }


}
