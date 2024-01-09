/*
package tacos.jms_service.recive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import tacos.entity.TacoOrder;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class JMSOrderReceiver implements OrderReceiver{
    private JmsTemplate jmsTemplate;

    private MessageConverter converter;

    @Autowired
    public JMSOrderReceiver(
            JmsTemplate jmsTemplate,
            MessageConverter converter) {
        this.jmsTemplate = jmsTemplate;
        this.converter = converter;
    }

    @Override
    public TacoOrder receiveOrder() throws JMSException {
        TacoOrder tacoOrder = (TacoOrder) jmsTemplate.receiveAndConvert("tacoNew.order.taco");
        System.out.println(tacoOrder.toString());

        return tacoOrder;
    }
}
*/
