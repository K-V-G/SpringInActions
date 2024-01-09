/*
package tacos.jms_service.send;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Service;
import tacos.entity.TacoOrder;

import javax.jms.Destination;

@Service
public class JmsOrderMessagingService implements OrderMessagingService {
    private JmsTemplate jmsTemplate;

    private Destination destination;

    private MappingJackson2MessageConverter mapping;

    public JmsOrderMessagingService(
            JmsTemplate jmsTemplate,
            Destination destination,
            MappingJackson2MessageConverter mapping) {
        this.jmsTemplate = jmsTemplate;
        this.destination = destination;
        this.mapping = mapping;
    }

    @Override
    public void sendOrder(TacoOrder order) {
       jmsTemplate.convertAndSend("tacoNew.order.taco", order, message -> {
           message.setStringProperty("_typeId", "order");
           message.setStringProperty("X_ORDER_SOURCE", "WEB");
           return message;
       });
    }
}

*/
