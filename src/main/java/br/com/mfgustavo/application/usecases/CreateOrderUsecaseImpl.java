package br.com.mfgustavo.application.usecases;

import br.com.mfgustavo.domain.entities.Order;
import br.com.mfgustavo.domain.gateway.OrderGateway;

public class CreateOrderUsecaseImpl implements CreateOrderUsecase {
    private final OrderGateway orderGateway;

    public CreateOrderUsecaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public Order execute(Order order) {
        return orderGateway.createOrder(order);
    }
}
