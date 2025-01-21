package br.com.mfgustavo.infrastruture.bean;

import br.com.mfgustavo.application.usecases.*;
import br.com.mfgustavo.domain.gateway.OrderGateway;
import br.com.mfgustavo.infrastruture.mapper.OrderDtoMapper;
import br.com.mfgustavo.infrastruture.mapper.OrderEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CreateOrderUsecase createOrderUsecase(OrderGateway orderGateway) {
        return new CreateOrderUsecaseImpl(orderGateway);
    }

    @Bean
    public GetOrdersUsecase getOrdersUsecase(OrderGateway orderGateway) {
        return new GetOrdersUsecaseImpl(orderGateway);
    }

    @Bean
    public FindOrderUsecase findOrderUsecase(OrderGateway orderGateway) {
        return new FindOrderUsecaseImpl(orderGateway);
    }

    @Bean
    public UpdateStatusOrderUsecase updateStatusOrderUsecase(OrderGateway orderGateway) {
        return new UpdateStatusOrderUsecaseImpl(orderGateway);
    }

    @Bean
    public OrderEntityMapper orderEntityMapper() {
        return new OrderEntityMapper();
    }

    @Bean
    public OrderDtoMapper orderDtoMapper() {
        return new OrderDtoMapper();
    }
}
