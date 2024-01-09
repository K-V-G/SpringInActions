package tacos.rabbit.send;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tacos.entity.TacoOrder;
import tacos.rabbit.send.OrderMessagingService;

@Service
public class RabbitOrderMessagingService implements OrderMessagingService {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitOrderMessagingService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendOrder(TacoOrder order) {
        rabbitTemplate.convertAndSend("taco", order, message -> {
            MessageProperties properties = message.getMessageProperties();
            properties.setHeader("X_ORDER_SOURCE", "WEB");
            return message;
        });
    }
}
