package br.com.mfgustavo.application.usecases;

import br.com.mfgustavo.domain.entities.Order;

public interface CreateOrderUsecase {
    Order execute(Order order);
}
