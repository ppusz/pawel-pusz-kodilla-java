package com.kodilla.good.patterns.challenges;

public class OrderProcessor {

    private OrderService orderService;
    private OrderRepository orderRepository;
    private InformationService informationService;

    public OrderProcessor(final OrderService orderService,
                          final OrderRepository orderRepository,
                          final InformationService informationService) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.informationService = informationService;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest);
        if (isOrdered){
            orderRepository.createOrder(orderRequest);
            informationService.inform(orderRequest);
        }
        return new OrderDto(orderRequest.getUser(), isOrdered);
    }
}
