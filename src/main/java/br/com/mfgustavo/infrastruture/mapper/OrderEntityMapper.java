package br.com.mfgustavo.infrastruture.mapper;

import br.com.mfgustavo.domain.entities.Order;
import br.com.mfgustavo.infrastruture.persistence.OrderEntity;

public class OrderEntityMapper {
    public OrderEntity toEntity(Order order) {
        return new OrderEntity(
                order.id(),
                order.status(),
                order.total()
        );
    }

    public Order toDomain(OrderEntity entity) {
        return new Order(
                entity.getId(),
                entity.getStatus(),
                entity.getTotal()
        );
    }
}
