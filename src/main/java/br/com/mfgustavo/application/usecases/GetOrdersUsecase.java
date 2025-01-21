package br.com.mfgustavo.application.usecases;

import br.com.mfgustavo.domain.entities.Order;

import java.util.List;

public interface GetOrdersUsecase {
    List<Order> execute();
}
