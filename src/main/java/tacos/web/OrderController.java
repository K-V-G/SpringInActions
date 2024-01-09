package tacos.web;
/*
import javax.jms.JMSException;
*/
import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import tacos.entity.TacoOrder;
import tacos.entity.User;
import tacos.data.OrderRepository;
import tacos.rabbit.recive.RabbitOrderReciver;
import tacos.rabbit.send.RabbitOrderMessagingService;
/*import tacos.jms_service.recive.JMSOrderReceiver;
import tacos.jms_service.send.JmsOrderMessagingService;*/

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

  private OrderRepository orderRepo;

  private RabbitOrderMessagingService rabbitService;

  private RabbitOrderReciver rabbitOrderReciver;

/*  private JmsOrderMessagingService messagingService;

  private JMSOrderReceiver messagingServiceRecive;*/

 /* public OrderController(OrderRepository orderRepo,
                         JmsOrderMessagingService messagingService,
                         JMSOrderReceiver messagingServiceRecive) {
    this.orderRepo = orderRepo;
    this.messagingService = messagingService;
    this.messagingServiceRecive = messagingServiceRecive;
  }*/

  public OrderController(
          OrderRepository orderRepo,
          RabbitOrderMessagingService rabbitService,
          RabbitOrderReciver rabbitOrderReciver) {
    this.orderRepo = orderRepo;
    this.rabbitService = rabbitService;
    this.rabbitOrderReciver = rabbitOrderReciver;
  }

  @GetMapping("/current")
  public String orderForm(@AuthenticationPrincipal User user,
      @ModelAttribute TacoOrder order) {
    return "orderForm";
  }

  @PostMapping
  public String processOrder(@Valid TacoOrder order, Errors errors,
      SessionStatus sessionStatus,
      @AuthenticationPrincipal User user) {

    if (errors.hasErrors()) {
      return "orderForm";
    }

    order.setUser(user);

/*
    messagingService.sendOrder(order);
*/
    orderRepo.save(order);
    rabbitService.sendOrder(order);
    sessionStatus.setComplete();
/*
    System.out.println(rabbitOrderReciver.receiveOrder().toString());
*/


    return "redirect:/";
  }

}
