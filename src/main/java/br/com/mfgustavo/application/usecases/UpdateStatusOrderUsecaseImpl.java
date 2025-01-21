package br.com.mfgustavo.application.usecases;

import br.com.mfgustavo.domain.entities.Order;
import br.com.mfgustavo.domain.enums.StatusOrder;
import br.com.mfgustavo.domain.gateway.OrderGateway;
import br.com.mfgustavo.infrastruture.exceptions.NotFoundOrderException;

public class UpdateStatusOrderUsecaseImpl implements UpdateStatusOrderUsecase {
    private final OrderGateway orderGateway;

    public UpdateStatusOrderUsecaseImpl(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    @Override
    public Order execute(Long id, StatusOrder statusOrder) {
        return orderGateway.updateStatusOrder(id, statusOrder)
                .orElseThrow(() -> new NotFoundOrderException("Order not found"));
    }
}
