package tacos.rabbit.recive;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import tacos.entity.TacoOrder;

@Component
public class RabbitOrderReciver implements OrderRecive{

    private RabbitTemplate rabbitTemplate;
    private MessageConverter converter;

    public RabbitOrderReciver(
            RabbitTemplate rabbitTemplate,
            MessageConverter converter) {
        this.rabbitTemplate = rabbitTemplate;
        this.converter = converter;
    }
    @Override
    public TacoOrder receiveOrder() {
        return rabbitTemplate.receiveAndConvert("taco", new ParameterizedTypeReference<TacoOrder>() {
        });
    }
}
