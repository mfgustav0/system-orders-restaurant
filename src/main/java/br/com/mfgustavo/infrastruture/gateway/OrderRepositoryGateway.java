package br.com.mfgustavo.infrastruture.gateway;

import br.com.mfgustavo.domain.entities.Order;
import br.com.mfgustavo.domain.enums.StatusOrder;
import br.com.mfgustavo.domain.gateway.OrderGateway;
import br.com.mfgustavo.infrastruture.mapper.OrderEntityMapper;
import br.com.mfgustavo.infrastruture.persistence.OrderEntity;
import br.com.mfgustavo.infrastruture.persistence.OrderEntityRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderRepositoryGateway implements OrderGateway {
    private final OrderEntityRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;

    public OrderRepositoryGateway(OrderEntityRepository orderRepository, OrderEntityMapper orderEntityMapper) {
        this.orderRepository = orderRepository;
        this.orderEntityMapper = orderEntityMapper;
    }

    @Override
    public List<Order> listOrders() {
        return orderRepository.findAll()
                .stream().map(orderEntityMapper::toDomain).toList();
    }

    @Override
    public Optional<Order> findById(Long id) {
        Optional<OrderEntity> entity = orderRepository.findById(id);
        return entity.map(orderEntityMapper::toDomain);
    }

    @Override
    public Order createOrder(Order order) {
        OrderEntity entity = orderEntityMapper.toEntity(order);
        entity.setStatus(StatusOrder.RECEIVED);
        OrderEntity newEntity = orderRepository.save(entity);
        return orderEntityMapper.toDomain(newEntity);
    }

    @Override
    public Optional<Order> updateStatusOrder(Long id, StatusOrder statusOrder) {
        Optional<OrderEntity> orderOpt = orderRepository.findById(id);
        if (orderOpt.isEmpty()) {
            return orderOpt.map(orderEntityMapper::toDomain);
        }

        OrderEntity order = orderOpt.get();
        order.setStatus(statusOrder);
        orderRepository.save(order);

        return Optional.ofNullable(orderEntityMapper.toDomain(order));
    }
}
