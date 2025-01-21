package br.com.mfgustavo.domain.gateway;

import br.com.mfgustavo.domain.entities.Order;
import br.com.mfgustavo.domain.enums.StatusOrder;

import java.util.List;
import java.util.Optional;

public interface OrderGateway {
    List<Order> listOrders();

    Optional<Order> findById(Long id);

    Order createOrder(Order order);

    Optional<Order> updateStatusOrder(Long id, StatusOrder statusOrder);
}
