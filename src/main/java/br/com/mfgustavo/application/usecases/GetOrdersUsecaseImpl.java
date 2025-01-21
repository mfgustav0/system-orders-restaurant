package br.com.mfgustavo.application.usecases;

import br.com.mfgustavo.domain.entities.Order;
import br.com.mfgustavo.domain.gateway.OrderGateway;

import java.util.List;

public class GetOrdersUsecaseImpl implements GetOrdersUsecase {
    private final OrderGateway orderGateway;

    public GetOrdersUsecaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public List<Order> execute() {
        return orderGateway.listOrders();
    }
}
