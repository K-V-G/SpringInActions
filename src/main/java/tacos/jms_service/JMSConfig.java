/*
package tacos.jms_service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import tacos.entity.TacoOrder;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import java.util.HashMap;
import java.util.Map;
@Configuration
@EnableJms
public class JMSConfig {

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setMessageConverter(messageConverter());
        return jmsTemplate;
    }

    @Bean
    public Destination orderQueue() {
        return new ActiveMQQueue("tacocloud.order.queue");
    }

    @Bean
    public MappingJackson2MessageConverter messageConverter() {
        MappingJackson2MessageConverter mappingJackson2MessageConverter =
                new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setTargetType(MessageType.TEXT);
        mappingJackson2MessageConverter.setTypeIdPropertyName("_typeId");

        Map<String, Class<?>> typeIdMapping = new HashMap<String, Class<?>>();
        typeIdMapping.put("order", TacoOrder.class);

        mappingJackson2MessageConverter.setTypeIdMappings(typeIdMapping);
        return mappingJackson2MessageConverter;
    }
}
*/
