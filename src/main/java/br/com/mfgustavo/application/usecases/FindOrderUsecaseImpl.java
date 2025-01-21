package br.com.mfgustavo.application.usecases;

import br.com.mfgustavo.domain.entities.Order;
import br.com.mfgustavo.domain.gateway.OrderGateway;
import br.com.mfgustavo.infrastruture.exceptions.NotFoundOrderException;

public class FindOrderUsecaseImpl implements FindOrderUsecase {
    private final OrderGateway orderGateway;

    public FindOrderUsecaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public Order execute(Long id) {
        return orderGateway.findById(id)
                .orElseThrow(() -> new NotFoundOrderException("Order not found"));
    }
}
