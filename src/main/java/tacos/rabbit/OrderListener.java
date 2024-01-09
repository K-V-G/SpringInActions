package tacos.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import tacos.entity.TacoOrder;

@Component
public class OrderListener {

    @RabbitListener(queues = "taco")
    public void receiveOrder(TacoOrder order) {
        System.out.println(order.toString());
    }
}
