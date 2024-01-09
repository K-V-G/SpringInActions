package tacos.rabbit.send;

import tacos.entity.TacoOrder;

public interface OrderMessagingService {
    void sendOrder(TacoOrder order);
}
