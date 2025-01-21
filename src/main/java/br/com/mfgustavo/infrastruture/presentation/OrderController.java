package br.com.mfgustavo.infrastruture.presentation;

import br.com.mfgustavo.application.usecases.CreateOrderUsecase;
import br.com.mfgustavo.application.usecases.FindOrderUsecase;
import br.com.mfgustavo.application.usecases.GetOrdersUsecase;
import br.com.mfgustavo.application.usecases.UpdateStatusOrderUsecase;
import br.com.mfgustavo.domain.entities.Order;
import br.com.mfgustavo.domain.enums.StatusOrder;
import br.com.mfgustavo.infrastruture.dtos.OrderDto;
import br.com.mfgustavo.infrastruture.mapper.OrderDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final CreateOrderUsecase createOrderUsecase;
    private final OrderDtoMapper orderDtoMapper;
    private final FindOrderUsecase getOrderUsecase;
    private final GetOrdersUsecase getOrdersUsecase;
    private final UpdateStatusOrderUsecase updateStatusOrderUsecase;

    public OrderController(CreateOrderUsecase createOrderUsecase,
                           OrderDtoMapper orderDtoMapper,
                           FindOrderUsecase getOrderUsecase,
                           GetOrdersUsecase getOrdersUsecase,
                           UpdateStatusOrderUsecase updateStatusOrderUsecase) {
        this.createOrderUsecase = createOrderUsecase;
        this.orderDtoMapper = orderDtoMapper;
        this.getOrderUsecase = getOrderUsecase;
        this.getOrdersUsecase = getOrdersUsecase;
        this.updateStatusOrderUsecase = updateStatusOrderUsecase;
    }

    @GetMapping
    public List<OrderDto> listOrders() {
        return getOrdersUsecase.execute()
                .stream().map(orderDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody OrderDto orderDto) {
        Order newOrder = createOrderUsecase.execute(orderDtoMapper.toDomain(orderDto));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Success to store order");
        response.put("data", orderDtoMapper.toDto(newOrder));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        Order order = getOrderUsecase.execute(id);

        return ResponseEntity.ok(order);
    }

    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<Order> updateStatusOrder(@PathVariable("id") Long id, @PathVariable("status") StatusOrder statusOrder) {
        Order order = updateStatusOrderUsecase.execute(id, statusOrder);

        return ResponseEntity.ok(order);
    }
}
