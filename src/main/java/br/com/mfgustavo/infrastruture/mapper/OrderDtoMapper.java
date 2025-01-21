package br.com.mfgustavo.infrastruture.mapper;

import br.com.mfgustavo.domain.entities.Order;
import br.com.mfgustavo.infrastruture.dtos.OrderDto;

public class OrderDtoMapper {
    public OrderDto toDto(Order order) {
        return new OrderDto(
                order.id(),
                order.status(),
                order.total()
        );
    }

    public Order toDomain(OrderDto orderDto) {
        return new Order(
                orderDto.id(),
                orderDto.status(),
                orderDto.total()
        );
    }
}
